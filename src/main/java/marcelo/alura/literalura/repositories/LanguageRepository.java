package marcelo.alura.literalura.repositories;

import marcelo.alura.literalura.entities.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<LanguageEntity,Long> {
    Optional<LanguageEntity> findByAbreviation(String abreviation);
}
