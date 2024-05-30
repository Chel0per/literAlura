package marcelo.alura.literalura.models;

import java.util.List;

public record ApiResponse(int count,String next,String previous,List<Book> results) {

}
