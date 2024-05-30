package marcelo.alura.literalura.repositories;

import marcelo.alura.literalura.entities.BookLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookLanguageRepository extends JpaRepository<BookLanguageEntity,Long> {
    List<BookLanguageEntity> findByBookId(Long bookId);

    List<BookLanguageEntity> findByLanguageId(Long languageId);
}
