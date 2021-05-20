package gr.codelearn.java.path.spring.test.bootstrap;

import gr.codelearn.java.path.spring.test.base.AbstractLogEntity;
import gr.codelearn.java.path.spring.test.domain.Movie;
import gr.codelearn.java.path.spring.test.service.MovieService;
import gr.codelearn.java.path.spring.test.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("movies-catalog")
@RequiredArgsConstructor
public class MoviesCatalogRunner extends AbstractLogEntity implements CommandLineRunner {
    private final MovieService movieService;
    private final PersonService personService;

    @Override
    public void run(String... args) {



        logger.debug("Reporting all People");
        personService.findAll().forEach(i -> logger.debug("{}", i));


        //@formatter:off
        Movie movie = Movie.builder().name("O daskalakos itan leventia").genre("romance")
                .rating(10).releaseDate("1970")
                .director(personService.findByLastname("Karagiannis")).build();


        movieService.addActor(movie, personService.findByLastname("Voutsas"));
        movieService.addActor(movie, personService.findByLastname("Papagiannopoylos"));

        logger.debug("Saving a movie");
        movieService.save(movie);

        Movie movie1 = Movie.builder().name("Egklima sto kolonaki").genre("crime")
                .rating(10).releaseDate("1960")
                .director(personService.findByLastname("Aliferis")).build();


        movieService.addActor(movie1, personService.findByLastname("Chagkaneas"));
        movieService.addActor(movie1, personService.findByLastname("Kontou"));
        movieService.addActor(movie1, personService.findByLastname("Mpertos"));
        movieService.addActor(movie1, personService.findByLastname("Mparkoulis"));
        movieService.addActor(movie1, personService.findByLastname("Papagiannopoylos"));

        logger.debug("Saving a movie");
        movieService.save(movie1);
        /* @formatter:on */



        logger.debug("Reporting all Movies");
        movieService.findAll().forEach(i -> logger.debug("{}", i));
    }

}
