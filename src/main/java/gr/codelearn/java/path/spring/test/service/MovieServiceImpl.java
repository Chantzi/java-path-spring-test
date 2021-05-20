package gr.codelearn.java.path.spring.test.service;

import gr.codelearn.java.path.spring.test.domain.Actor;
import gr.codelearn.java.path.spring.test.domain.Movie;
import gr.codelearn.java.path.spring.test.domain.Person;
import gr.codelearn.java.path.spring.test.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends AbstractServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }



    @Override
    public void addActor(Movie movie, Person person) {
        if (checkNullability(movie, person)) return;
        movie.add(Actor.builder().person(person).movie(movie).build());
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAllLazy();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findByIdLazy(id);
    }

    private boolean checkNullability(Movie movie, Person person) {
        if (movie == null) {
            logger.warn("Movie is null.");
            return true;
        }
        if (person == null) {
            logger.warn("Person is null.");
            return true;
        }
        return false;
    }


}
