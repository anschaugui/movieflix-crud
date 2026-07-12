package movieflix.com.br.movieflix.service;

import lombok.RequiredArgsConstructor;
import movieflix.com.br.movieflix.entity.Category;
import movieflix.com.br.movieflix.entity.Movie;
import movieflix.com.br.movieflix.entity.Streaming;
import movieflix.com.br.movieflix.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;


    public Movie save(Movie movie) {
        this.findCategories(movie.getCategories());
        return repository.save(movie);
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> {
            categoryService.findById(category.getId()).ifPresent(categoriesFound::add);
        });
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingFound = new ArrayList<>();
        streamings.forEach(streaming -> {
            streamingService.findById(streaming.getId()).ifPresent(streamingFound::add);
        });
        return streamingFound;
    }
}
