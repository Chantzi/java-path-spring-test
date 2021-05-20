package gr.codelearn.java.path.spring.test.controller;

import gr.codelearn.java.path.spring.test.domain.Person;
import gr.codelearn.java.path.spring.test.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    public PersonService getBaseService(){

        return personService;
    }
}
