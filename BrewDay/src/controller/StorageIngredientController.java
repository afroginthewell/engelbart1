package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

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
	public void updateAmount(ArrayList<JTextArea> inputList, ArrayList<StorageIngredient> sIngredientList) throws SQLException {
		// Connected with Dao
		storageingredientDaoiml sidi = new storageingredientDaoiml();
		
		// Write Data to Database
		for (int i = 0; i < inputList.size(); i++) {
			
			// Fetch the amount
			String inputTemp = inputList.get(i).getText().toString();
			
			// Empty Error handle
			if (inputTemp.equals("")) {inputTemp = "0.0";}
			
			double changedAmount=0;
			try {
				changedAmount = Double.parseDouble(inputTemp);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				
			}
			
			
			double updatedAmount = sIngredientList.get(i).getAmount() + changedAmount;
			sIngredientList.get(i).setAmount(updatedAmount);
			if(updatedAmount<0)
			{
				sIngredientList.get(i).setAmount(0);
			}
			
			try {
				sidi.update(sIngredientList.get(i));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void addNewIngredient(String name, Double amount) throws SQLException {
		// Connected with Dao
		storageingredientDaoiml sidi = new storageingredientDaoiml();
		int newIngreIndex = sidi.getMaxIndex() + 1;
		model.setindex(newIngreIndex);
		model.setName(name);
		model.setAmount(amount);
		model.setUnit("g");
		sidi.add(model);
	}

	public ArrayList<StorageIngredient> updateView() throws SQLException {
		storageingredientDaoiml sidi = new storageingredientDaoiml();
		ArrayList<StorageIngredient> sIngredientList = new ArrayList<StorageIngredient>();
		sIngredientList = (ArrayList<StorageIngredient>) sidi.findAll();
		return sIngredientList;
	}
}
