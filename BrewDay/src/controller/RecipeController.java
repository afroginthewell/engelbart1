package controller;

import java.sql.SQLException;

import Dao.recipeDao;
import Daoiml.recipeDaoiml;
import model.Recipe;
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

	// FUNCTION: Unfinished
	boolean convertToAbsValue(double quantity) {
		return true;
	}

	boolean updateRecipes(int oldRecipeIndex, Recipe newRecipe) throws SQLException {
		// Implement the DAO object
		recipeDao RecipeDAO = new recipeDaoiml();
		RecipeDAO.update(newRecipe);
		return true;
	}
}
