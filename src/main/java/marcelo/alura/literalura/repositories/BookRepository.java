package marcelo.alura.literalura.repositories;

import marcelo.alura.literalura.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
