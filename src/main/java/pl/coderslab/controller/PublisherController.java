package pl.coderslab.controller;


import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

  private final PublisherDao publisherDao;

  public PublisherController(PublisherDao publisherDao) {
    this.publisherDao = publisherDao;
  }

  @GetMapping("/{id}")
  @ResponseBody
  public String getPublisher(@PathVariable long id) {
    return publisherDao.findById(id).toString();
  }

  @GetMapping("/optional/{id}")
  @ResponseBody
  public String getOptionalPublisher(@PathVariable long id) {
    return publisherDao.optionalFindById(id).orElseThrow(RuntimeException::new).toString();
  }

  @PostMapping
  @ResponseBody
  public String createPublisher() {
    Publisher publisher = new Publisher();
    publisher.setName("Super wydawca");

    return publisherDao.create(publisher).toString();
  }

  @PutMapping("/{id}")
  @ResponseBody
  public String updatePublisher(@PathVariable long id, @RequestParam String name) {
    Publisher publisher = publisherDao.optionalFindById(id)
        .orElseThrow(() -> new RuntimeException("Co ty chcesz edytowac ?"));
    publisher.setName(name);

    return publisherDao.update(publisher).toString();
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public void deletePublisher(@PathVariable long id) {
    Optional<Publisher> maybePublisher = publisherDao.optionalFindById(id);

    maybePublisher.ifPresent(publisherDao::remove);
  }


}
