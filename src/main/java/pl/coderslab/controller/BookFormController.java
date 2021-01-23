package pl.coderslab.controller;


import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
@RequestMapping("/form/book")
public class BookFormController {

  private final BookDao bookDao;
  private final PublisherDao publisherDao;

  public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
    this.bookDao = bookDao;
    this.publisherDao = publisherDao;
  }

  @GetMapping
  public String getForm(Model model){
    model.addAttribute("book", new Book());
    return "bookForm";
  }

  @ModelAttribute("publishers")
  public List<Publisher> getPublishers(){
    return publisherDao.findAll();
  }

  @PostMapping
  public String addBook(@ModelAttribute @Valid Book book, BindingResult result){
    if(result.hasErrors()){
      return "bookForm";
    }
    bookDao.create(book);
    return "redirect:/books";
  }






  @GetMapping("/testData")
  @ResponseBody
  public String testData(){
    publisherDao.create(new Publisher("Tomek"));
    publisherDao.create(new Publisher("Michal"));
    publisherDao.create(new Publisher("Łukasz"));
    publisherDao.create(new Publisher("Kuba"));
    publisherDao.create(new Publisher("Karol"));
    publisherDao.create(new Publisher("Makary"));

    return "ok";
  }
}
