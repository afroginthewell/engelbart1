package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Daoiml.storageingredientDaoiml;
import model.StorageIngredient;
import view.StorageIngredientView;

public class StorageIngredientController extends Controller {
	private StorageIngredient model;


	// Constructor
	public StorageIngredientController(StorageIngredient model) {
		super(model);
		this.model = model;
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
	
	public ArrayList<StorageIngredient> updateView() throws SQLException {
		storageingredientDaoiml sidi = new storageingredientDaoiml();
		ArrayList<StorageIngredient> sIngredientList = new ArrayList<StorageIngredient>();
		sIngredientList = (ArrayList<StorageIngredient>) sidi.findAll();
		return sIngredientList;
	}
}
