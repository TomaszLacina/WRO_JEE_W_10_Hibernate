package pl.coderslab.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findByTitle(String title);
  List<Book> findByCategory(Category category);
  List<Book> findByCategoryId(Long categoryId);
//  List<Book> findByCategoryName(Long categoryName);

}
