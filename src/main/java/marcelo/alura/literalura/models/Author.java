package marcelo.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Author {

    public final String name;
    @JsonAlias("birth_year")
    public final int birthYear;
    @JsonAlias("death_year")
    public final int deathYear;

    public Author(int birthYear, String name, int deathYear) {
        this.birthYear = birthYear;
        this.name = name;
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "Author{" +
                "birthYear=" + birthYear +
                ", name='" + name + '\'' +
                ", deathYear=" + deathYear +
                '}';
    }
}
