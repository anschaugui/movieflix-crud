package movieflix.com.br.movieflix.service;

import movieflix.com.br.movieflix.entity.Category;
import movieflix.com.br.movieflix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    CategoryService(CategoryRepository categoryRepository){
        this.repository = categoryRepository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }
}
