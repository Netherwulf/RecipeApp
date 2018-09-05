package netherwulf.springframework.recipeapp.commands;

public class CategoryCommand {
    private String id;
    private String description;

    public CategoryCommand() {
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
