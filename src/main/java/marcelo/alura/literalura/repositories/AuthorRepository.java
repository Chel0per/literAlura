package marcelo.alura.literalura.repositories;

import marcelo.alura.literalura.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
    Optional<AuthorEntity> findByName(String name);
}
