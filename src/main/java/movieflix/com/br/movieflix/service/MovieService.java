package movieflix.com.br.movieflix.service;

import movieflix.com.br.movieflix.entity.Movie;
import movieflix.com.br.movieflix.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }


    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }
}
