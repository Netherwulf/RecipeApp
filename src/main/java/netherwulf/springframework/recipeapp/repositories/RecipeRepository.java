package netherwulf.springframework.recipeapp.repositories;

import netherwulf.springframework.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Iterable<Recipe> findAll();
}
