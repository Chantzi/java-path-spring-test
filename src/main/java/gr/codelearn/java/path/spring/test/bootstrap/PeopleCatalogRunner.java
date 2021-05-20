package gr.codelearn.java.path.spring.test.bootstrap;

import gr.codelearn.java.path.spring.test.base.AbstractLogEntity;
import gr.codelearn.java.path.spring.test.domain.Person;
import gr.codelearn.java.path.spring.test.domain.PersonRole;
import gr.codelearn.java.path.spring.test.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("people-catalog")
@RequiredArgsConstructor
public class PeopleCatalogRunner extends AbstractLogEntity implements CommandLineRunner {
    private final PersonService personService;

    @Override
    public void run(String... args) {

//@formatter:off
        List<Person> people = List.of(
                Person.builder().firstname("Kostas").lastname("Voutsas")
                        .dateOfBirth("31-12-1931").dateOfDeath("26-02-20")
                        .personRole(PersonRole.ACTOR).build(),
                Person.builder().firstname("Dionisis").lastname("Papagiannopoylos")
                        .dateOfBirth("12-07-1912").dateOfDeath("13-08-1984")
                        .personRole(PersonRole.ACTOR).build(),
                Person.builder().firstname("Kostas").lastname("Karagiannis")
                        .dateOfBirth("1932").dateOfDeath("17-02-1993")
                        .personRole(PersonRole.DIRECTOR).build());

        logger.debug("Saving some people");
        personService.saveAll(people);

        List<Person> people1 = List.of(
                Person.builder().firstname("Christos").lastname("Chagkaneas")
                        .dateOfBirth("02-07-1906").dateOfDeath("02-07-1976")
                        .personRole(PersonRole.ACTOR).build(),
                Person.builder().firstname("Maro").lastname("Kontou")
                        .dateOfBirth("21-06-1934")
                        .personRole(PersonRole.ACTOR).build(),
                Person.builder().firstname("Giannis").lastname("Mpertos")
                        .dateOfBirth("1903")
                        .personRole(PersonRole.ACTOR).build(),
                Person.builder().firstname("Antreas").lastname("Mparkoulis")
                        .dateOfBirth("04-08-1936").dateOfDeath("23-08-2016")
                        .personRole(PersonRole.ACTOR).build(),
                Person.builder().firstname("Tzanis").lastname("Aliferis")
                        .dateOfBirth("1917").dateOfDeath("2013")
                        .personRole(PersonRole.DIRECTOR).build());

        logger.debug("Saving some people");
        personService.saveAll(people1);
        /* @formatter:on */

    }
}
