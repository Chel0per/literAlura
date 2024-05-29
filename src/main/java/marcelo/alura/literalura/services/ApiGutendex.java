package marcelo.alura.literalura.services;

import marcelo.alura.literalura.models.Book;

import java.net.http.HttpClient;
import java.util.List;

public class ApiGutendex {

    private final HttpClient client;

    public ApiGutendex() {
        client = HttpClient.newHttpClient();
    }

    public List<Book> getBooksByFilter(String filter){
        return null;
    }

}
