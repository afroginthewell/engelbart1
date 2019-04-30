package model;

public class Recipe {
	
	private int recipeIndex;
	private String name;
	private double quantity;
	private String unit;
	
	// Constructor
	public Recipe(int recipeIndex, String name, double quantity, String unit) {
		super();
		this.recipeIndex = recipeIndex;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}
	
	// Getter and Setter
	public int getRecipeIndex() {
		return recipeIndex;
	}

	public void setRecipeIndex(int recipeIndex) {
		this.recipeIndex = recipeIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	// FUNCTION
	boolean convertToAbsValue(double quantity) {
		return true;
	}
	
	boolean updateRecipes(int oldRecipeIndex, Recipe newRecipe) {
		return true;
	}
}
