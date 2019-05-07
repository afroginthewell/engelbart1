package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.equipDao;
import Daoiml.equipDaoiml;

import model.Equipment;
import view.EquipmentView;

public class EquipmentController extends Controller{

	private Equipment model;

	// Constructor
	public EquipmentController(Equipment model) {
		super(model);
		this.model=model;
		//this.model=model;
	}

	// Member function
	public boolean updateCapacity(double addCapacityVolumn) throws SQLException {
		equipDaoiml edi = new equipDaoiml();

		// Error Handle: Capacity cannot be negative value
		if (model.getCapacity() + addCapacityVolumn < 0)
			return false;

		// Update the capacity
		model.setCapacity(model.getCapacity() + addCapacityVolumn);
		edi.update(model);

		return true;
	}
	
	public void addEquipment(String name, double capacity) throws SQLException {
		equipDaoiml edi = new equipDaoiml();
		int newEquipIndex = edi.getMaxIndex() + 1;
		model.setEquipmentIndex(newEquipIndex);		
		model.setCapacity(capacity);
		model.setName(name);
		edi.add(model);
	}
	
	public ArrayList<Equipment> updateView() throws SQLException {
		equipDaoiml edi = new equipDaoiml();
		ArrayList<Equipment> equipList = new ArrayList<Equipment>();
		equipList = (ArrayList<Equipment>) edi.findAll();
		return equipList;
	}
	
	// Update view

}
