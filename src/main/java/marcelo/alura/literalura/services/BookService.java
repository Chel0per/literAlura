package marcelo.alura.literalura.services;

import marcelo.alura.literalura.entities.*;
import marcelo.alura.literalura.models.Author;
import marcelo.alura.literalura.models.Book;
import marcelo.alura.literalura.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private BookAuthorRepository bookAuthorRepository;
    @Autowired
    private BookLanguageRepository bookLanguageRepository;

    public void signBook(Book book) {

        BookEntity bookE = new BookEntity(book.downloadCount(), book.title());
        BookEntity savedBook = bookRepository.save(bookE);
        Long bookId = savedBook.getId();

        for (Author author : book.authors()) {
            Optional<AuthorEntity> foundAuthor = authorRepository.findByName(author.name());
            if (foundAuthor.isPresent()) {
                Long authorId = foundAuthor.get().getId();
                BookAuthorEntity BArelation = new BookAuthorEntity(authorId, bookId);
                bookAuthorRepository.save(BArelation);
            } else {
                AuthorEntity newAuthor = new AuthorEntity(author.birthYear(), author.deathYear(), author.name());
                AuthorEntity savedAuthor = authorRepository.save(newAuthor);
                Long authorId = savedAuthor.getId();
                BookAuthorEntity BArelation = new BookAuthorEntity(authorId, bookId);
                bookAuthorRepository.save(BArelation);
            }
        }

        for (String language : book.languages()) {
            Optional<LanguageEntity> foundLanguage = languageRepository.findByAbreviation(language);
            if (foundLanguage.isPresent()) {
                Long languageId = foundLanguage.get().getId();
                BookLanguageEntity BLrelation = new BookLanguageEntity(bookId, languageId);
                bookLanguageRepository.save(BLrelation);
            } else {
                LanguageEntity newLanguage = new LanguageEntity(language);
                LanguageEntity savedLanguage = languageRepository.save(newLanguage);
                Long languageId = savedLanguage.getId();
                BookLanguageEntity BLrelation = new BookLanguageEntity(bookId, languageId);
                bookLanguageRepository.save(BLrelation);
            }
        }
    }

    public void getBooks(){
        List<BookEntity> books = bookRepository.findAll();
        List<Book> serializedBooks = bookSerialize(books);
        int i = 1;
        for(Book serializedBook: serializedBooks){
            System.out.println(i + " - " + serializedBook);
            i++;
        }
    }

    public void getBooksByAuthor(AuthorEntity author){
        List<BookAuthorEntity> BArelations = bookAuthorRepository.findByAuthorId(author.getId());
        List<Long> bookIds = new ArrayList<>();
        for(BookAuthorEntity relation : BArelations){
            bookIds.add(relation.getBookId());
        }
        List<BookEntity> books = bookRepository.findAllById(bookIds);
        List<Book> serializedBooks = bookSerialize(books);
        System.out.println("Livros com o autor " + author.getName());
        int i = 1;
        for(Book serializedBook: serializedBooks){
            System.out.println(i + " - " + serializedBook);
            i++;
        }
    }

    public List<AuthorEntity> getAuthors(){
        List<AuthorEntity> authors = authorRepository.findAll();
        int i = 1;
        for(AuthorEntity author: authors){
            System.out.println(i + " - " + author);
            i++;
        }
        return authors;
    }

    private List<Book> bookSerialize(List<BookEntity> books){
        List<Book> serializedBooks = new ArrayList<>();
        for (BookEntity book: books){
            Book serializedBook = new Book(book.getTitle(),new ArrayList<>(),new ArrayList<>(),book.getDownloadCount());
            List<BookAuthorEntity> BArelations = bookAuthorRepository.findByBookId(book.getId());
            List<Long> authorIds = new ArrayList<>();
            for (BookAuthorEntity relation : BArelations){
                authorIds.add(relation.getAuthorId());
            }
            List<AuthorEntity> authors = authorRepository.findAllById(authorIds);
            for (AuthorEntity author: authors){
                serializedBook.authors().add(new Author(author.getName(),author.getBirthYear(), author.getDeathYear()));
            }
            List<BookLanguageEntity> BLrelations = bookLanguageRepository.findByBookId(book.getId());
            List<Long> languageIds = new ArrayList<>();
            for (BookLanguageEntity relation : BLrelations){
                languageIds.add(relation.getLanguageId());
            }
            List<LanguageEntity> languages = languageRepository.findAllById(languageIds);
            for (LanguageEntity language: languages){
                serializedBook.languages().add(language.getAbreviation());
            }
            serializedBooks.add(serializedBook);
        }
        return serializedBooks;
    }

    public List<LanguageEntity> getLanguages() {
        List<LanguageEntity> languages = languageRepository.findAll();
        int i = 1;
        for(LanguageEntity language: languages){
            System.out.println(i + " - " + language.getAbreviation());
            i++;
        }
        return languages;
    }

    public void getBooksByLanguage(LanguageEntity language) {
        List<BookLanguageEntity> BLrelations = bookLanguageRepository.findByLanguageId(language.getId());
        List<Long> languageIds = new ArrayList<>();
        for(BookLanguageEntity relation : BLrelations){
            languageIds.add(relation.getBookId());
        }
        List<BookEntity> books = bookRepository.findAllById(languageIds);
        List<Book> serializedBooks = bookSerialize(books);
        System.out.println("Livros com a língua " + language.getAbreviation());
        int i = 1;
        for(Book serializedBook: serializedBooks){
            System.out.println(i + " - " + serializedBook);
            i++;
        }
    }
}
