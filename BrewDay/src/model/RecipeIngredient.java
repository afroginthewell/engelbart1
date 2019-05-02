package model;

public class RecipeIngredient extends Ingredient {
	int recipeIndex;
	// Constructor
	public RecipeIngredient(int Index, String name, double amount, String unit,int recipeIndex) {
		super(Index,name, amount, unit);
		this.recipeIndex=recipeIndex;
	}
	public void setrecipeIndex(int recipeIndex) {
		this.recipeIndex = recipeIndex;
	}

	public int getrecipeIndex() {
		return recipeIndex;
	}
	
	
}