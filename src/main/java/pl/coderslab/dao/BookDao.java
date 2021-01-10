package pl.coderslab.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Book;

@Repository
@Transactional
public class BookDao {

  @PersistenceContext
  private EntityManager entityManager;

  public Book findById(long id) {
    return entityManager.find(Book.class, id);
  }

  public Optional<Book> optionalFindById(long id) {
    return Optional.ofNullable(entityManager.find(Book.class, id));
  }

  public Book create(Book book) {
    entityManager.persist(book);
    return book;
  }

  public Book update(Book book) {
    entityManager.merge(book);
    return book;
  }

  public void remove(Book book) {
    Book bookForRemoval = entityManager.contains(book) ? book : entityManager.merge(book);

    entityManager.remove(bookForRemoval);
  }

  public List<Book> findAll(){
    Query query = entityManager.createQuery("SELECT b FROM Book b");

    return query.getResultList();
  }

  public List<Book> findByRatingGreaterThen(int rating){
    Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating > :rating");
    query.setParameter("rating", rating);

    return query.getResultList();
  }

}
