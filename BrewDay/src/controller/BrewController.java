package controller;
import model.Brew;
import model.Equipment;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;
import view.BrewView;

import java.util.ArrayList;

public class BrewController {
	private Brew model;
	private BrewView view;
	
	// FUNCTIONS
		public boolean implement(Recipe recipe, double batchSize, Equipment equipment) {
			
			// Create arraylist to store the data fetch from database
			ArrayList<StorageIngredient> SIList = new ArrayList<StorageIngredient>();
			
			// Implement the DAO object
			storageIngredientDao sIDao = new storageIngredientDaoiml();
			recipeIngredientDao rIngDao = new recipeIngredientDaoiml();
			
			// Fetch data from database
			SIList = sIDao.findAll();
			
			// Error handle: If batch size is smaller than 0, reject
			if (batchSize <= 0)
				return false;

			// Error handle: If batch size is larger than avaliable capacity, reject
			if (getCapacity(equipment) < batchSize) {
				return false;
			}
			
			// subtract the amount
			double amount = batchSize / recipe.getQuantity();
			ArrayList<RecipeIngredient> corrRIList = new ArrayList<RecipeIngredient>();
			corrRIList = rIngDao.findRecipeWithIndex(recipe.getRecipeIndex());
			for (RecipeIngredient ri: corrRIList) {
				double needAmount = ri.getAmount() * amount;
				for (StorageIngredient si: SIList) {
					// Fine the matched ingredient
					if(ri.getName().equals(si.getName())) {
						// Check if the Stored amount is larger than need amount
						si.setAmount(si.getAmount() - needAmount);
						sIDao.update(si);
					}
				} 
			}
			
			// Write the note
			
			return true;
		}
		
		public ArrayList<Recipe> recommendRecipe(double batchSize){
			
			// Create arraylist to store the data fetch from database
			ArrayList<Recipe> rRecipeList = new ArrayList<Recipe>();
			ArrayList<Recipe> allRecipeList = new ArrayList<Recipe>();
			ArrayList<StorageIngredient> SIList = new ArrayList<StorageIngredient>();
			ArrayList<RecipeIngredient> RIList = new ArrayList<RecipeIngredient>();
			
			// Implement the DAO object
			recipeDao RecipeDAO = new recipeDaoiml();
			storageIngredientDao sIDao = new storageIngredientDaoiml();
			recipeIngredientDao rIngDao = new recipeIngredientDaoiml();
			
			// Fetch data from database
			allRecipeList = RecipeDAO.findAll();
			RIList = rIngDao.findAll();
			SIList = sIDao.findAll();
			
			// Subtract out the fake avaliable recipes
			for(Recipe i: allRecipeList) {
				// Fine the corresponding recipe ingredient for this recipe
				ArrayList<RecipeIngredient> corrRIList = new ArrayList<RecipeIngredient>();
				corrRIList = rIngDao.findRecipeWithIndex(i.getRecipeIndex());
				double amount = batchSize / i.getQuantity();
				for (RecipeIngredient ri: corrRIList) {
					// Get this Recipe ingredient's need amount
					double needAmount = ri.getAmount() * amount;
					// compare with this ingredient in store
						// Fetch the information of store Ingredient firstly
					for (StorageIngredient si: SIList) {
						// Fine the matched ingredient
						if(ri.getName().equals(si.getName())) {
							// Check if the Stored amount is larger than need amount
							if(si.getAmount() >= needAmount) {
								rRecipeList.add(i);
							}
						}
					}
				}
				
			}
			return rRecipeList;
		}
		
		public double getCapacity(Equipment equipment) {
			return equipment.getCapacity();
		}
}
