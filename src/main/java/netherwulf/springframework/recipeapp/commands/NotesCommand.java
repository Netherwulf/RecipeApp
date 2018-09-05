package netherwulf.springframework.recipeapp.commands;

public class NotesCommand {
    private String id;
    private String recipeNotes;

    public NotesCommand() {
    }

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
