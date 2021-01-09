package pl.coderslab.dao;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;

@Repository
@Transactional
public class AuthorDao {

  @PersistenceContext
  private EntityManager entityManager;

  public Author findById(long id){
    return entityManager.find(Author.class, id);
  }

  public Optional<Author> optionalFindById(long id){
    return Optional.ofNullable(entityManager.find(Author.class, id));
  }

  public Author create(Author author){
    entityManager.persist(author);
    return author;
  }

  public Author update(Author author){
    entityManager.merge(author);
    return author;
  }

  public void remove(Author author){
    Author authorForRemoval = entityManager.contains(author) ? author : entityManager.merge(author);

    entityManager.remove(authorForRemoval);
  }

}
