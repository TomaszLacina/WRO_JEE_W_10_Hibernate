package pl.coderslab.dao;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Publisher;

@Repository
@Transactional
public class PublisherDao {

  @PersistenceContext
  private EntityManager entityManager;


  public Publisher findById(long id){
    return entityManager.find(Publisher.class, id);
  }

  public Optional<Publisher> optionalFindById(long id){
    return Optional.ofNullable(entityManager.find(Publisher.class, id));
  }

  public Publisher create(Publisher publisher){
    entityManager.persist(publisher);
    return publisher;
  }

  public Publisher update(Publisher publisher){
    entityManager.merge(publisher);
    return publisher;
  }

  public void remove(Publisher publisher){
    Publisher publisherForRemoval = entityManager.contains(publisher) ? publisher : entityManager.merge(publisher);

    entityManager.remove(publisherForRemoval);
  }

}
