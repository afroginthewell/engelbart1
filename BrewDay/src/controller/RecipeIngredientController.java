package controller;

import model.RecipeIngredient;
import view.RecipeIngredientView;

import java.sql.SQLException;

import Daoiml.RecipeingredientDaoiml;

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
	boolean updateAmount(double changeAmount) throws SQLException {

		RecipeingredientDaoiml ri = new RecipeingredientDaoiml();

		// Error Handle: Capacity cannot be negative value
		if (model.getAmount() + changeAmount < 0)
			return false;

		// Set the amount to the new amount
		model.setAmount(model.getAmount() + changeAmount);
		ri.update(model);

		return true;
	}
}
