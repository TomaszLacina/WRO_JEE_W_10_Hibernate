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
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

  private final AuthorDao authorDao;

  public AuthorController(AuthorDao authorDao) {
    this.authorDao = authorDao;
  }

  @GetMapping("/{id}")
  @ResponseBody
  public String getAuthor(@PathVariable long id) {
    return authorDao.findById(id).toString();
  }

  @GetMapping("/optional/{id}")
  @ResponseBody
  public String getOptionalAuthor(@PathVariable long id) {
    return authorDao.optionalFindById(id).orElseThrow(RuntimeException::new).toString();
  }

  @PostMapping
  @ResponseBody
  public String createAuthor() {
    Author author = new Author();
    author.setFirstName("Tomasz");
    author.setLastName("Lacina");
    return authorDao.create(author).toString();
  }

  @PutMapping("/{id}")
  @ResponseBody
  public String updateAuthor(@PathVariable long id, @RequestParam String firstName) {
    Author author = authorDao.optionalFindById(id).orElseThrow(() -> new RuntimeException("Co ty chcesz edytowac ?"));
    author.setFirstName(firstName);

    return authorDao.update(author).toString();
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public void  deleteAuthor(@PathVariable long id){
    Optional<Author> maybeAuthor = authorDao.optionalFindById(id);

    maybeAuthor.ifPresent(authorDao::remove);
  }


}
