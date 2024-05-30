package marcelo.alura.literalura.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(String title,List<Author> authors,List<String> languages,@JsonAlias("download_count") int downloadCount) {

    @Override
    public String toString() {
        return "Livro{" +
                "Autores=" + authors +
                ", Título='" + title + '\'' +
                ", Línguas=" + languages +
                ", Número de downloads=" + downloadCount +
                '}';
    }
}
