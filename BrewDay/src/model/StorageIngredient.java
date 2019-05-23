package model;

import java.sql.SQLException;

import view.View;

public class StorageIngredient extends Ingredient {

	// Constructor
	public StorageIngredient(int index, String name, double amount, String unit) {
		super(index, name, amount, unit);
	}

	public StorageIngredient() {
		super();
	}

	// Rewrite
	//update all view in the model
	public void notifyView() throws SQLException {
		for (View v: super.views) {
			v.update();
		}
	}

}
