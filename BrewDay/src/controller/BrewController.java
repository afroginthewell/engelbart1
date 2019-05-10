package controller;

import model.Brew;
import model.Equipment;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;

import Dao.storageingredientDao;
import Dao.recipeDao;
import Dao.RecipeIngredientDao;
import Dao.equipDao;
import Dao.noteDao;
import Daoiml.equipDaoiml;
import Daoiml.noteDaoiml;
import Daoiml.recipeDaoiml;
import Daoiml.RecipeingredientDaoiml;
import Daoiml.storageingredientDaoiml;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrewController extends Controller{
	private Brew model;
	

	public BrewController(Brew model) {
		super(model);
		this.model = model;
	}

	// FUNCTIONS
		public boolean implement(int recipeindex, double batchSize) throws SQLException {
			
			// Create arraylist to store the data fetch from database
			ArrayList<StorageIngredient> SIList = new ArrayList<StorageIngredient>();
			
			recipeDao rdi = new recipeDaoiml();
			Recipe recipe=rdi.findById(recipeindex);
			// Implement the DAO object
			storageingredientDao sIDao = new storageingredientDaoiml();
			RecipeIngredientDao rIngDao = new RecipeingredientDaoiml();
			equipDao e=new equipDaoiml();
			
			// Fetch data from database
			SIList = (ArrayList<StorageIngredient>) sIDao.findAll();
			
			// Error handle: If batch size is smaller than 0, reject
			if (batchSize <= 0)
				return false;

			// Error handle: If batch size is larger than avaliable capacity, reject
			if (e.getTotalCapacity()< batchSize) {
				return false;
			}
			
			// subtract the amount
			double amount = batchSize / recipe.getQuantity();
			ArrayList<RecipeIngredient> corrRIList = new ArrayList<RecipeIngredient>();
			corrRIList = (ArrayList<RecipeIngredient>) rIngDao.findbyrecipe(recipe.getRecipeIndex());
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
		
		
public boolean computeamount(int recipeindex, double batchSize) throws SQLException {
			
			storageingredientDao sIDao = new storageingredientDaoiml();
			RecipeIngredientDao rIngDao = new RecipeingredientDaoiml();
			recipeDao rdi = new recipeDaoiml();
			ArrayList<StorageIngredient> SIList = new ArrayList<StorageIngredient>();			
			ArrayList<Double> shopingAmount=new ArrayList<Double>();
			Recipe recipe=rdi.findById(recipeindex);
			equipDao e=new equipDaoiml();
			
			// Fetch data from database
			SIList = (ArrayList<StorageIngredient>) sIDao.findAll();
			
			// Error handle: If batch size is smaller than 0, reject
			if (batchSize <= 0)
				return false;

			// Error handle: If batch size is larger than avaliable capacity, reject
			if (e.getTotalCapacity()< batchSize) {
				return false;
			}
			
			// subtract the amount
			double amount = batchSize / recipe.getQuantity();
			ArrayList<RecipeIngredient> corrRIList = new ArrayList<RecipeIngredient>();
			corrRIList = (ArrayList<RecipeIngredient>) rIngDao.findbyrecipe(recipe.getRecipeIndex());
			for (RecipeIngredient ri: corrRIList) {
				double needAmount = ri.getAmount() * amount;
				for (StorageIngredient si: SIList) {
					// Fine the matched ingredient
					if(ri.getName().equals(si.getName())) {
						// Check if the Stored amount is larger than need amount
						shopingAmount.add(needAmount-si.getAmount());				
					}
				} 
			}
			model.setShopingAmount(shopingAmount);
			// Write the note
			
			return true;
		}	
		
		
		
		

	public ArrayList<Recipe> recommendRecipe(double batchSize) throws SQLException {

		// Create arraylist to store the data fetch from database
		ArrayList<Recipe> rRecipeList = new ArrayList<Recipe>();
		ArrayList<Recipe> nRecipeList = new ArrayList<Recipe>();
		ArrayList<Recipe> allRecipeList = new ArrayList<Recipe>();
		ArrayList<StorageIngredient> SIList = new ArrayList<StorageIngredient>();
		ArrayList<RecipeIngredient> RIList = new ArrayList<RecipeIngredient>();

		// Implement the DAO object
		recipeDao RecipeDAO = new recipeDaoiml();
		storageingredientDao sIDao = new storageingredientDaoiml();
		RecipeIngredientDao rIngDao = new RecipeingredientDaoiml();

		// Fetch data from database
		allRecipeList = (ArrayList<Recipe>) RecipeDAO.findAll();
		RIList = (ArrayList<RecipeIngredient>) rIngDao.findAll();
		SIList = (ArrayList<StorageIngredient>) sIDao.findAll();

		// Subtract out the fake avaliable recipes
		for (Recipe i : allRecipeList) {
			int flag = 0;
			// Fine the corresponding recipe ingredient for this recipe
			ArrayList<RecipeIngredient> corrRIList = new ArrayList<RecipeIngredient>();
			corrRIList = (ArrayList<RecipeIngredient>) rIngDao.findbyrecipe(i.getRecipeIndex());
			double amount = batchSize / i.getQuantity();
			for (RecipeIngredient ri : corrRIList) {
				// Get this Recipe ingredient's need amount
				double needAmount = ri.getAmount() * amount;
				// compare with this ingredient in store
				// Fetch the information of store Ingredient firstly
				for (StorageIngredient si : SIList) {
					// Fine the matched ingredient
					if (ri.getName().equals(si.getName())) {
						// Check if the Stored amount is larger than need amount
						if (si.getAmount() < needAmount) {
							flag = 1;

						}
					}
				}
			}
			if (flag == 0) 
			{
				rRecipeList.add(i);
			}
			if (flag == 1) 
			{
				nRecipeList.add(i);
			}
		}
		model.setRecommendedRecipeIndex(rRecipeList);
		model.setnotRecommendedRecipeIndex(nRecipeList);	
		return rRecipeList;
	}

	public double getCapacity(Equipment equipment) {
		return equipment.getCapacity();
	}

}
