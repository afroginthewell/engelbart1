package controller;

import java.sql.SQLException;

import Daoiml.storageingredientDaoiml;
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
		public boolean addAmount(int ingredientIndex, double amount) throws SQLException {
			storageingredientDaoiml si = new storageingredientDaoiml();

			// Error Handle: add amount's value cannot be negative value
			if (amount < 0)
				return false;

			// Set the amount to the new amount
			model.setAmount(model.getAmount() + amount);
			si.update(model);

			return true;
		}
		
		public boolean subtractAmount(int ingredientIndex, double amount) throws SQLException {
			storageingredientDaoiml si = new storageingredientDaoiml();

			// Error Handle: add amount's value cannot be negative value
			if (amount > 0)
				return false;

			// Set the amount to the new amount
			model.setAmount(model.getAmount() - amount);
			si.update(model);

			return true;
		}
}
