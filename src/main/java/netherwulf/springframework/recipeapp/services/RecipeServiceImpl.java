package netherwulf.springframework.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import netherwulf.springframework.recipeapp.commands.RecipeCommand;
import netherwulf.springframework.recipeapp.converters.RecipeCommandToRecipe;
import netherwulf.springframework.recipeapp.converters.RecipeToRecipeCommand;
import netherwulf.springframework.recipeapp.domain.Recipe;
import netherwulf.springframework.recipeapp.exceptions.NotFoundException;
import netherwulf.springframework.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("I'm inside RecipeService"); //usage of Project Lombok

        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new NotFoundException("Recipe not found for ID value: " + id.toString());
        }

        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
