package controller;

import model.RecipeIngredient;
import view.RecipeIngredientView;

public class RecipeIngredientController {
	private RecipeIngredient model;
	private RecipeIngredientView view;

	// Constructor
	public RecipeIngredientController(RecipeIngredient model, RecipeIngredientView view) {
		super();
		this.model = model;
		this.view = view;
	}

	// FUNCTIONS
	boolean updateAmount(double changeAmount) {
		return true;
	}
}
