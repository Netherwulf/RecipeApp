package netherwulf.springframework.recipeapp.domain;

import org.springframework.data.annotation.Id;

public class Notes {

    @Id
    private String id;
    private String recipeNotes;

    public String getId() {
        return this.id;
    }

    public String getRecipeNotes() {
        return this.recipeNotes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
