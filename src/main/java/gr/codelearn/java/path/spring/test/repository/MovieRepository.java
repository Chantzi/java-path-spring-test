package gr.codelearn.java.path.spring.test.repository;

import gr.codelearn.java.path.spring.test.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m join fetch m.actor where m.id = ?1")
    Movie findByIdLazy(Long id);

    @Query("select distinct m from Movie m join fetch m.actor")
    List<Movie> findAllLazy();
}
