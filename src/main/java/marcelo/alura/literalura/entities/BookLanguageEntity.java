package marcelo.alura.literalura.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books_languages")
public class BookLanguageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "language_id")
    private Long languageId;

    public BookLanguageEntity(){};

    public BookLanguageEntity(Long bookId, Long languageId) {
        this.bookId = bookId;
        this.languageId = languageId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getId() {
        return id;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }
}