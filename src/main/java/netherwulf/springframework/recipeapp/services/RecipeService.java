package netherwulf.springframework.recipeapp.services;

import netherwulf.springframework.recipeapp.commands.RecipeCommand;
import netherwulf.springframework.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String id);
}
