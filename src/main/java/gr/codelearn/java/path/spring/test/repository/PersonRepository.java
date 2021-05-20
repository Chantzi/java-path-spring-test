package gr.codelearn.java.path.spring.test.repository;

import gr.codelearn.java.path.spring.test.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByLastname(String lastname);
}
