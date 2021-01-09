package pl.coderslab.dao;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Book;

@Repository
@Transactional
public class BookDao {

  @PersistenceContext
  private EntityManager entityManager;

  public Book findById(long id){
    return entityManager.find(Book.class, id);
  }

  public Optional<Book> optionalFindById(long id){
    return Optional.ofNullable(entityManager.find(Book.class, id));
  }

  public Book create(Book book){
    entityManager.persist(book);
    return book;
  }

  public Book update(Book book){
    entityManager.merge(book);
    return book;
  }

  public void remove(Book book){
    Book bookForRemoval = entityManager.contains(book) ? book : entityManager.merge(book);

    entityManager.remove(bookForRemoval);
  }

}
