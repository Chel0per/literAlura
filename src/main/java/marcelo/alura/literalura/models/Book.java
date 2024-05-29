package marcelo.alura.literalura.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    private final String title;
    private final List<Author> authors;
    private final List<String> languages;
    @JsonAlias("download_count")
    private int downloadCount;

    public Book(List<Author> authors, int downloadCount, List<String> languages, String title) {
        this.authors = authors;
        this.downloadCount = downloadCount;
        this.languages = languages;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", title='" + title + '\'' +
                ", languages=" + languages +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
