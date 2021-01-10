package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Controller
@RequestMapping("/persons")
public class PersonController {

  private final PersonDao personDao;

  public PersonController(PersonDao personDao) {
    this.personDao = personDao;
  }

  @GetMapping("/form")
  public String addForm(Model model) {
    model.addAttribute("person", new Person());
    return "personForm";
  }

  @PostMapping("/form")
  @ResponseBody
  public String addForm(Person person) {
    personDao.create(person);

    return person.toString();
  }
}
