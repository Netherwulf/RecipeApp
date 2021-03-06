package netherwulf.springframework.recipeapp.services;

import netherwulf.springframework.recipeapp.converters.RecipeCommandToRecipe;
import netherwulf.springframework.recipeapp.converters.RecipeToRecipeCommand;
import netherwulf.springframework.recipeapp.domain.Recipe;
import netherwulf.springframework.recipeapp.exceptions.NotFoundException;
import netherwulf.springframework.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    RecipeToRecipeCommand recipeToRecipeCommand;
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeToRecipeCommand, recipeCommandToRecipe);
    }

    @Test
    public void getRecipeByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTestNotFound() {
        Optional<Recipe> recipeOptional = Optional.empty();

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);
    }

//    @Test
//    public void getRecipeCommandByIdTest() throws Exception{
//        Recipe recipe = new Recipe();
//        recipe.setId(1L);
//        Optional<Recipe> recipeOptional = Optional.of(recipe);
//
//        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
//
//        RecipeCommand recipeCommand = new RecipeCommand();
//        recipeCommand.setId(1L);
//
//        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);
//
//        RecipeCommand commandById = recipeService.findCommandById(1L);
//
//        assertNotNull("Null recipe returned", commandById);
//        verify(recipeRepository, times(1)).findById(anyLong());
//        verify(recipeRepository, never()).findAll();
//    }

    @Test
    public void getRecipesTest() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);

        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        //given
        Long idToDelete = 1L;

        //when
        recipeService.deleteById(idToDelete);

        //then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}