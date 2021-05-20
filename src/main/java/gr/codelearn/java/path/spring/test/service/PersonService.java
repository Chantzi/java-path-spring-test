package gr.codelearn.java.path.spring.test.service;


import gr.codelearn.java.path.spring.test.domain.Person;

public interface PersonService extends BaseService<Person, Long> {
    Person findByLastname(String lastname);

}
