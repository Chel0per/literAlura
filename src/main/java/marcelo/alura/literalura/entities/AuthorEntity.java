package marcelo.alura.literalura.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="birth_year")
    private int birthYear;
    @Column(name="death_year")
    private int deathYear;

    public AuthorEntity() {};

    public AuthorEntity(int birthYear, int deathYear, String name) {
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "Nome='" + name +
                ", Ano de nascimento=" + birthYear +
                ", Ano de falecimento=" + deathYear +
                '}';
    }
}
