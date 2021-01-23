package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
