package marcelo.alura.literalura.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import marcelo.alura.literalura.entities.AuthorEntity;
import marcelo.alura.literalura.entities.LanguageEntity;
import marcelo.alura.literalura.models.ApiResponse;
import marcelo.alura.literalura.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ApiGutendex {

    private final HttpClient client;
    private final ObjectMapper objectMapper;
    private UserInput APIinput;
    @Autowired
    private BookService bookService;

    public ApiGutendex() {
        APIinput = new UserInput();
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public ApiResponse getApiResponseByFilter(String filter) throws IOException, InterruptedException {
        String encodedFilter = URLEncoder.encode(filter, StandardCharsets.UTF_8);
        String uriString = "https://gutendex.com/books?search=" + encodedFilter;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 301){
            String newLocation = response.headers().firstValue("Location").orElse("");
            HttpRequest redirectRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://gutendex.com" + newLocation))
                    .build();
            response = client.send(redirectRequest, HttpResponse.BodyHandlers.ofString());
        }
        String jsonString = response.body();
        return objectMapper.readValue(jsonString,ApiResponse.class);
    }

    public ApiResponse getOtherPage(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 301){
            String newLocation = response.headers().firstValue("Location").orElse("");
            HttpRequest redirectRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://gutendex.com" + newLocation))
                    .build();
            response = client.send(redirectRequest, HttpResponse.BodyHandlers.ofString());
        }
        String jsonString = response.body();
        return objectMapper.readValue(jsonString,ApiResponse.class);
    }

    public void chooseBookWithFilter() throws IOException, InterruptedException{
        APIinput = new UserInput();
        String filter = APIinput.getFilter();
        ApiResponse response = getApiResponseByFilter(filter);

        List<Book> books = response.results();
        int index = 1;

        for(Book book : books){
            System.out.println(index + " - " + book);
            index++;
        }

        if( response.next() == null && response.previous() == null){
            int signChoice = APIinput.getUserSignChoiceNN();
            switch(signChoice){
                case 1:
                    signBook(books);
                    break;
                case 2:
                    chooseBookWithFilter();
                    break;
                default:
                    break;
            }
        }
        else if(response.next() == null){
            APIinput = new UserInput();
            int signChoice = APIinput.getUserSignChoiceNP();
            switch(signChoice){
                case 1:
                    signBook(books);
                    break;
                case 2:
                    chooseBookWithFilter();
                    break;
                case 3:
                    response = getOtherPage(response.previous());
                    chooseBookWithPage(response);
                default:
                    break;
            }
        }
        else if(response.previous() == null){
            APIinput = new UserInput();
            int signChoice = APIinput.getUserSignChoicePN();
            switch(signChoice){
                case 1:
                    signBook(books);
                    break;
                case 2:
                    chooseBookWithFilter();
                    break;
                case 3:
                    response = getOtherPage(response.next());
                    chooseBookWithPage(response);
                default:
                    break;
            }
        }
        else {
            APIinput = new UserInput();
            int signChoice = APIinput.getUserSignChoicePP();
            switch(signChoice){
                case 1:
                    signBook(books);
                    break;
                case 2:
                    chooseBookWithFilter();
                    break;
                case 3:
                    response = getOtherPage(response.next());
                    chooseBookWithPage(response);
                case 4:
                    response = getOtherPage(response.previous());
                    chooseBookWithPage(response);
                default:
                    break;
            }
        }
    }

    public void chooseBookWithPage(ApiResponse response) throws IOException, InterruptedException{

        List<Book> books = response.results();
        int index = 1;

        for(Book book : books){
            System.out.println(index + " - " + book);
            index++;
        }

        if( response.next() == null && response.previous() == null){
            APIinput = new UserInput();
            int signChoice = APIinput.getUserSignChoiceNN();
            switch(signChoice){
                case 1:
                    signBook(books);
                    break;
                case 2:
                    chooseBookWithFilter();
                    break;
                default:
                    break;
            }
        }
        else if(response.next() == null){
            APIinput = new UserInput();
            int signChoice = APIinput.getUserSignChoiceNP();
            switch(signChoice){
                case 1:
                    signBook(books);
                    break;
                case 2:
                    chooseBookWithFilter();
                    break;
                case 3:
                    response = getOtherPage(response.previous());
                    chooseBookWithPage(response);
                default:
                    break;
            }
        }
        else if(response.previous() == null){
            APIinput = new UserInput();
            int signChoice = APIinput.getUserSignChoicePN();
            switch(signChoice){
                case 1:
                    signBook(books);
                    break;
                case 2:
                    chooseBookWithFilter();
                    break;
                case 3:
                    response = getOtherPage(response.next());
                    chooseBookWithPage(response);
                default:
                    break;
            }
        }
        else {
            APIinput = new UserInput();
            int signChoice = APIinput.getUserSignChoicePP();
            switch(signChoice){
                case 1:
                    signBook(books);
                    break;
                case 2:
                    chooseBookWithFilter();
                    break;
                case 3:
                    response = getOtherPage(response.next());
                    chooseBookWithPage(response);
                case 4:
                    response = getOtherPage(response.previous());
                    chooseBookWithPage(response);

                default:
                    break;
            }
        }
    }

    public void signBook(List<Book> books){

        int bookNumber;

        do {
            bookNumber = APIinput.chooseBook();
            if (bookNumber < 1 || bookNumber > books.size()) System.out.println("Por favor digite um dos números listados acima.");
        } while (bookNumber < 1 || bookNumber > books.size());

        Book chosenBook = books.get(bookNumber - 1);

        bookService.signBook(chosenBook);

    }

    public void listBooks() {
        bookService.getBooks();
    }

    public void listBooksByAuthor() {
        List<AuthorEntity> authors = bookService.getAuthors();

        int authorNumber;

        do {
            authorNumber = APIinput.chooseAuthor();
            if (authorNumber < 1 || authorNumber > authors.size()) System.out.println("Por favor digite o número de um dos autores listados acima.");
        } while (authorNumber < 1 || authorNumber > authors.size());

        AuthorEntity chosenAuthor = authors.get(authorNumber - 1);

        bookService.getBooksByAuthor(chosenAuthor);

    }

    public void listBooksByLanguage() {
        List<LanguageEntity> languages = bookService.getLanguages();

        int languageNumber;

        do {
            languageNumber = APIinput.chooseLanguage();
            if (languageNumber < 1 || languageNumber > languages.size()) System.out.println("Por favor digite o número de uma das línguas listadas acima.");
        } while (languageNumber < 1 || languageNumber > languages.size());

        LanguageEntity chosenLanguage = languages.get(languageNumber - 1);

        bookService.getBooksByLanguage(chosenLanguage);
    }
}