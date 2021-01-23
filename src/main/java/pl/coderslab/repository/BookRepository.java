package pl.coderslab.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findByTitle(String title);
  List<Book> findByCategory(Category category);
  List<Book> findByCategoryId(Long categoryId);
//  List<Book> findByCategoryName(Long categoryName);


  @Query("SELECT b FROM Book b where b.title = :title")
  List<Book> getAllByTitleHehe(@Param("title") String title);

  @Query("SELECT b FROM Book b where b.category = :category")
  List<Book> getAllByCategory(@Param("category") Category category);
}
