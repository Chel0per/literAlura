package marcelo.alura.literalura.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class LanguageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String abreviation;

    public LanguageEntity(){};

    public LanguageEntity(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public Long getId() {
        return id;
    }
}
