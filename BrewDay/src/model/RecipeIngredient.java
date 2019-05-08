package model;

import java.sql.SQLException;

import view.View;

public class RecipeIngredient extends Ingredient{
	int recipeIndex;
	// Constructor
	public RecipeIngredient(int Index, String name, double amount, String unit,int recipeIndex) {
		super(Index,name, amount, unit);
		this.recipeIndex=recipeIndex;
	}
	public RecipeIngredient() {
		super();
		
	}
	public void setrecipeIndex(int recipeIndex) {
		this.recipeIndex = recipeIndex;
	}

	public int getrecipeIndex() {
		return recipeIndex;
	}
	public void notifyView() throws SQLException {
		for (View v: super.views) {
			v.update();
		}
	} 
	
	
}