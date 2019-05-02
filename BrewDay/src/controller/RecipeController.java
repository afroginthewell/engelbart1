package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.recipeDao;
import Daoiml.RecipeingredientDaoiml;
import Daoiml.recipeDaoiml;
import model.Recipe;
import model.RecipeIngredient;
import view.RecipeView;

public class RecipeController {
	private Recipe model;
	private RecipeView view;

	// Constructor
	public RecipeController(Recipe model, RecipeView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	// Add recipe and Delete recipe
	public void addRecipe(String name, double quantity, String unit, ArrayList<RecipeIngredient> recipeIngredientList) throws SQLException {
		recipeDaoiml rdi = new recipeDaoiml();
		// Handle for recipe
		Recipe tempRecipe = new Recipe(rdi.getMaxIndex()+1, name, quantity, unit);
		rdi.add(tempRecipe);
		
		// Handle for recipe ingredients
		RecipeingredientDaoiml ridi = new RecipeingredientDaoiml();
		
		for (RecipeIngredient ri: recipeIngredientList) {
			ri.setrecipeIndex(rdi.getMaxIndex() + 1);
			ri.setindex(ridi.getMaxIndex() + 1);
			ridi.add(ri);
		}
	}
	
	// Delete Recipe
	public void deleteRecipe(int targetIndex) throws SQLException {
		recipeDaoiml rdi = new recipeDaoiml();
		RecipeingredientDaoiml ridi = new RecipeingredientDaoiml();
		
		// Delete the recipe ingredient first
		ArrayList<RecipeIngredient> deleteRecipeIngredientList = new ArrayList<RecipeIngredient>();
		deleteRecipeIngredientList = (ArrayList<RecipeIngredient>) ridi.findbyrecipe(targetIndex);
		for(RecipeIngredient dri: deleteRecipeIngredientList) {
			ridi.delete(dri.getindex());
		}
		
		// Then we delete the recipe
		rdi.delete(targetIndex);
	}
	
	// Turing Complete
	public ArrayList<Double> convertToAbsValue(double quantity) throws SQLException {
		RecipeingredientDaoiml ridi = new RecipeingredientDaoiml();
		ArrayList<RecipeIngredient> recipeIngredientList = new ArrayList<RecipeIngredient>();
		// To record converted value
		ArrayList<Double> convertedList = new ArrayList<Double>();
		recipeIngredientList = (ArrayList<RecipeIngredient>) ridi.findbyrecipe(model.getRecipeIndex());
		
		for(int i = 0; i < recipeIngredientList.size(); i++) {
			convertedList.set(i, recipeIngredientList.get(i).getAmount() * quantity);
		}
		
		return convertedList; 
	}

	public boolean updateRecipes(int oldRecipeIndex, Recipe newRecipe) throws SQLException {
		// Implement the DAO object
		recipeDao RecipeDAO = new recipeDaoiml();
		RecipeDAO.update(newRecipe);
		return true;
	}
}
