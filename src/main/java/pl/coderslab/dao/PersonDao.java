package pl.coderslab.dao;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Person;

@Repository
@Transactional
public class PersonDao {

  @PersistenceContext
  private EntityManager entityManager;


  public Person findById(long id){
    return entityManager.find(Person.class, id);
  }

  public Optional<Person> optionalFindById(long id){
    return Optional.ofNullable(entityManager.find(Person.class, id));
  }

  public Person create(Person person){
    entityManager.persist(person);
    return person;
  }

  public Person update(Person person){
    entityManager.merge(person);
    return person;
  }

  public void remove(Person person){
    Person personForRemoval = entityManager.contains(person) ? person : entityManager.merge(person);

    entityManager.remove(personForRemoval);
  }

}
