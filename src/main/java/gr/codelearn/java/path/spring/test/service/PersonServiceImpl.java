package gr.codelearn.java.path.spring.test.service;

import gr.codelearn.java.path.spring.test.domain.Person;
import gr.codelearn.java.path.spring.test.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends AbstractServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    public Person findByLastname(String lastname) {
        return personRepository.findByLastname(lastname);
    }
}
