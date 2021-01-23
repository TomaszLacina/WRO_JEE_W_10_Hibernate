package pl.coderslab.controller;

import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

@Controller
@RequestMapping("/validation")
public class ValidationController {

  @Autowired
  Validator validator;

  @GetMapping("/book")
  @ResponseBody
  public String validateBook() {
    Book book = new Book();

    Set<ConstraintViolation<Book>> validationResult = validator.validate(book);

    return validationResult.stream().map(
        bookConstraintViolation -> bookConstraintViolation.getPropertyPath() + " : " + bookConstraintViolation
            .getMessage())
        .collect(Collectors.joining(" <br> "));
  }
}
