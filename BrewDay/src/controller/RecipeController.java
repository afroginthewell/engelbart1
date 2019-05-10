package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.RecipeIngredientDao;
import Dao.recipeDao;
import Daoiml.RecipeingredientDaoiml;
import Daoiml.recipeDaoiml;
import model.Recipe;
import model.RecipeIngredient;


public class RecipeController extends Controller{
	private Recipe model;
	

	// Constructor
	public RecipeController(Recipe model) {
		super(model);
		this.model = model;		
	}
	
	// Add recipe and Delete recipe
	public int addRecipe(String name, double quantity, String unit) throws SQLException {
		recipeDao rdi = new recipeDaoiml();
		// Handle for recipe
		int a=rdi.getMaxIndex()+1;
		model.setName(name);
		model.setQuantity(quantity);
		model.setRecipeIndex(a);
		model.setUnit(unit);		
		rdi.add(model);	
		return a;
	}
	
	// Delete Recipe
	public void deleteRecipe(int targetIndex) throws SQLException {
		recipeDao rdi = new recipeDaoiml();
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

	public boolean updateRecipes(String name, double amount, int id) throws SQLException {
		// Implement the DAO object
		recipeDao RecipeDAO = new recipeDaoiml();
		model=RecipeDAO.findById(id);
		model.setName(name);
		model.setQuantity(amount);
		RecipeDAO.update(model);
		return true;
	}
	public ArrayList<Recipe> updateRecipeView() throws SQLException {
		ArrayList<Recipe> RecipeList = new ArrayList<Recipe>();
		recipeDao rdi = new recipeDaoiml();
		RecipeList = (ArrayList<Recipe>) rdi.findAll();
		return RecipeList;
	}

}
