package controller;

import model.Equipment;
import model.RecipeIngredient;
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
	public boolean updateAmount(double changeAmount,int recipeid) throws SQLException {

		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		model=ri.findById(recipeid);
		model.setAmount(changeAmount);
		if(changeAmount<0)
		{
			model.setAmount(0);
		}
		ri.update(model);

		return true;
	}
	public boolean deleteRecipeIngredient(int recipeid) throws SQLException {

		RecipeIngredientDao ri = new RecipeingredientDaoiml();	
		ArrayList<RecipeIngredient> deleteRecipeIngredientList = new ArrayList<RecipeIngredient>();
		deleteRecipeIngredientList = (ArrayList<RecipeIngredient>) ri.findbyrecipe(recipeid);
		for(RecipeIngredient dri: deleteRecipeIngredientList) {
			ri.delete(dri.getindex());
		}

		return true;
	}
	
	
	
	public void addRecipeIngredient(String name, double amount,String unit,int recipeindex) throws SQLException {
		
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		int newIndex = ri.getMaxIndex() + 1;
		model.setName(name);
		
		
		model.setAmount(amount);
		if(amount<0)
		{
			model.setAmount(0);
		}
		
		model.setUnit(unit);
		model.setrecipeIndex(recipeindex);
		model.setindex(newIndex);
		ri.add(model);
	}
	
	// Update view
	public ArrayList<RecipeIngredient> updateRecipeIngredientView() throws SQLException {
		ArrayList<RecipeIngredient> RecipeIngredientList = new ArrayList<RecipeIngredient>();
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		RecipeIngredientList = (ArrayList<RecipeIngredient>) ri.findAll();
		return RecipeIngredientList;
	}	
	
	public ArrayList<RecipeIngredient> GetByRecipe(int id) throws SQLException {
		ArrayList<RecipeIngredient> RecipeIngredientList = new ArrayList<RecipeIngredient>();
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		RecipeIngredientList = (ArrayList<RecipeIngredient>) ri.findbyrecipe(id);
		return RecipeIngredientList;
	}	
}
