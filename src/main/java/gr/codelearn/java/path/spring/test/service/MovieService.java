package gr.codelearn.java.path.spring.test.service;

import gr.codelearn.java.path.spring.test.domain.Movie;
import gr.codelearn.java.path.spring.test.domain.Person;

public interface MovieService extends BaseService<Movie, Long> {

    void addActor(Movie movie, Person person);
}
