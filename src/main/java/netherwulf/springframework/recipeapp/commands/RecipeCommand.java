package netherwulf.springframework.recipeapp.commands;

import netherwulf.springframework.recipeapp.domain.Difficulty;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RecipeCommand {
    private String id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String description;

    @Min(1)
    @Max(999)
    private Integer prepTime;

    @Min(1)
    @Max(999)
    private Integer cookTime;

    @Min(1)
    @Max(100)
    private Integer servings;

    private String source;

    @URL
    private String url;

    @NotBlank
    private String directions;

    private List<IngredientCommand> ingredients = new ArrayList<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private List<CategoryCommand> categories = new ArrayList<>();

    public RecipeCommand() {
    }

    public String getId() {
        return this.id;
    }

    public @NotBlank @Size(min = 3, max = 255) String getDescription() {
        return this.description;
    }

    public @Min(1) @Max(999) Integer getPrepTime() {
        return this.prepTime;
    }

    public @Min(1) @Max(999) Integer getCookTime() {
        return this.cookTime;
    }

    public @Min(1) @Max(100) Integer getServings() {
        return this.servings;
    }

    public String getSource() {
        return this.source;
    }

    public @URL String getUrl() {
        return this.url;
    }

    public @NotBlank String getDirections() {
        return this.directions;
    }

    public List<IngredientCommand> getIngredients() {
        return this.ingredients;
    }

    public Byte[] getImage() {
        return this.image;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public NotesCommand getNotes() {
        return this.notes;
    }

    public List<CategoryCommand> getCategories() {
        return this.categories;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(@NotBlank @Size(min = 3, max = 255) String description) {
        this.description = description;
    }

    public void setPrepTime(@Min(1) @Max(999) Integer prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(@Min(1) @Max(999) Integer cookTime) {
        this.cookTime = cookTime;
    }

    public void setServings(@Min(1) @Max(100) Integer servings) {
        this.servings = servings;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUrl(@URL String url) {
        this.url = url;
    }

    public void setDirections(@NotBlank String directions) {
        this.directions = directions;
    }

    public void setIngredients(List<IngredientCommand> ingredients) {
        this.ingredients = ingredients;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setNotes(NotesCommand notes) {
        this.notes = notes;
    }

    public void setCategories(List<CategoryCommand> categories) {
        this.categories = categories;
    }
}
