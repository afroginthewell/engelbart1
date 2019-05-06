package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.RecipeIngredientDao;
import Dao.recipeDao;
import Daoiml.RecipeingredientDaoiml;
import Daoiml.recipeDaoiml;
import model.Recipe;
import model.RecipeIngredient;
import view.RecipeView;

public class RecipeController {
	private Recipe model;
	

	// Constructor
	public RecipeController(Recipe model) {
		super();
		this.model = model;		
	}
	
	// Add recipe and Delete recipe
	public void addRecipe(String name, double quantity, String unit) throws SQLException {
		recipeDao rdi = new recipeDaoiml();
		// Handle for recipe
		Recipe tempRecipe = new Recipe(rdi.getMaxIndex()+1, name, quantity, unit);
		rdi.add(tempRecipe);	
	}
	
	// Delete Recipe
	public void deleteRecipe(int targetIndex) throws SQLException {
		recipeDao rdi = new recipeDaoiml();
		RecipeIngredientDao ridi = new RecipeingredientDaoiml();
		
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

	public boolean updateRecipes(String name, double amount, Recipe r) throws SQLException {
		// Implement the DAO object
		recipeDao RecipeDAO = new recipeDaoiml();
		r.setName(name);
		r.setQuantity(amount);
		RecipeDAO.update(r);
		return true;
	}
	public ArrayList<Recipe> updateRecipeView() throws SQLException {
		ArrayList<Recipe> RecipeList = new ArrayList<Recipe>();
		recipeDao rdi = new recipeDaoiml();
		RecipeList = (ArrayList<Recipe>) rdi.findAll();
		return RecipeList;
	}
	
}
