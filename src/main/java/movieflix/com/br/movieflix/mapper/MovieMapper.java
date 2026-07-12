package movieflix.com.br.movieflix.mapper;

import lombok.experimental.UtilityClass;
import movieflix.com.br.movieflix.controller.request.MovieRequest;
import movieflix.com.br.movieflix.controller.response.CategoryResponse;
import movieflix.com.br.movieflix.controller.response.MovieResponse;
import movieflix.com.br.movieflix.controller.response.StreamingResponse;
import movieflix.com.br.movieflix.entity.Category;
import movieflix.com.br.movieflix.entity.Movie;
import movieflix.com.br.movieflix.entity.Streaming;

import java.util.List;
import java.util.stream.Stream;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request) {

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();


        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streaming(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {

        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamings = movie.getStreaming()
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

}
