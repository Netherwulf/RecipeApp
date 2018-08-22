package netherwulf.springframework.recipeapp.services;

import netherwulf.springframework.recipeapp.commands.RecipeCommand;
import netherwulf.springframework.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long id);
}
