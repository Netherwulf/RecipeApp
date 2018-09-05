package netherwulf.springframework.recipeapp.commands;

import java.math.BigDecimal;

public class IngredientCommand {
    private String id;
    private String recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasure;

    public IngredientCommand() {
    }

    public String getId() {
        return this.id;
    }

    public String getRecipeId() {
        return this.recipeId;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public UnitOfMeasureCommand getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setUnitOfMeasure(UnitOfMeasureCommand unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
