package marcelo.alura.literalura.repositories;

import marcelo.alura.literalura.entities.BookAuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthorEntity,Long> {
    List<BookAuthorEntity> findByBookId(Long bookId);

    List<BookAuthorEntity> findByAuthorId(Long authorId);
}
