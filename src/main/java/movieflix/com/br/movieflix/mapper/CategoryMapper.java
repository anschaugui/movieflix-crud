package movieflix.com.br.movieflix.mapper;

import lombok.experimental.UtilityClass;
import movieflix.com.br.movieflix.controller.request.CategoryRequest;
import movieflix.com.br.movieflix.controller.response.CategoryResponse;
import movieflix.com.br.movieflix.entity.Category;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest request){
        return Category
                .builder()
                .name(request.name())
                .build();
    }

    public static CategoryResponse  toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
