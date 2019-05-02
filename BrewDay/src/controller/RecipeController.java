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

	// Turing Complete
	ArrayList<Double> convertToAbsValue(double quantity) throws SQLException {
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

	boolean updateRecipes(int oldRecipeIndex, Recipe newRecipe) throws SQLException {
		// Implement the DAO object
		recipeDao RecipeDAO = new recipeDaoiml();
		RecipeDAO.update(newRecipe);
		return true;
	}
}
