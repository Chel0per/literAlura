package marcelo.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Author(String name,@JsonAlias("birth_year") int birthYear,@JsonAlias("death_year") int deathYear) {

    @Override
    public String toString() {
        return "Autor{" +
                "Nome='" + name +
                ", Ano de nascimento=" + birthYear +
                ", Ano de falecimento=" + deathYear +
                '}';
    }
}
