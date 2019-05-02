package controller;

import model.StorageIngredient;
import view.StorageIngredientView;

public class StorageIngredientController {
	private StorageIngredient model;
	private StorageIngredientView view;

	// Constructor
	public StorageIngredientController(StorageIngredient model, StorageIngredientView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	// FUNCTIONS
		public boolean addAmount(int ingredientIndex, double amount) {
			return true;
		}
		
		public boolean subtractAmount(int ingredientIndex, double amount) {
			return true;
		}
}
