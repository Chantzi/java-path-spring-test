package gr.codelearn.java.path.spring.test.controller;

import gr.codelearn.java.path.spring.test.domain.Movie;
import gr.codelearn.java.path.spring.test.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieControler extends AbstractController<Movie> {

    private final MovieService movieService;

    public MovieService getBaseService(){
        return movieService;
    }
}
