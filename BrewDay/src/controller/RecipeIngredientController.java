package controller;

import model.Equipment;
import model.RecipeIngredient;
import view.RecipeIngredientView;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.RecipeIngredientDao;
import Dao.equipDao;
import Daoiml.RecipeingredientDaoiml;
import Daoiml.equipDaoiml;

public class RecipeIngredientController {
	private RecipeIngredient model;
	
	// Constructor
	public RecipeIngredientController(RecipeIngredient model) {
		super();
		this.model = model;	
		
	}

	// FUNCTIONS
	boolean updateAmount(double changeAmount,int recipeid) throws SQLException {

		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		RecipeIngredient r=ri.findById(recipeid);
		// Error Handle: Capacity cannot be negative value
		if (r.getAmount() + changeAmount < 0)
			return false;

		// Set the amount to the new amount
		r.setAmount(r.getAmount() + changeAmount);
		ri.update(r);

		return true;
	}
	
	
	
	public void addRecipeIngredient(String name, double amount,String unit,int recipeindex) throws SQLException {
		
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		int newrecipeIndex = ri.getMaxIndex() + 1;
		RecipeIngredient newRecipeIngredient= new RecipeIngredient(newrecipeIndex, name,amount, unit,recipeindex);
		ri.add(newRecipeIngredient);
	}
	
	// Update view
	public ArrayList<RecipeIngredient> updateRecipeIngredientView() throws SQLException {
		ArrayList<RecipeIngredient> RecipeIngredientList = new ArrayList<RecipeIngredient>();
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		RecipeIngredientList = (ArrayList<RecipeIngredient>) ri.findAll();
		return RecipeIngredientList;
	}
}
