package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.equipDao;
import Daoiml.equipDaoiml;

import model.Equipment;
import view.EquipmentView;

public class EquipmentController {

	private Equipment model;

	// Constructor
	public EquipmentController(Equipment model) {
		super();
		this.model = model;
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
		Equipment newEquipment= new Equipment(edi.getMaxIndex(), name, capacity);
		edi.add(newEquipment);
	}
	
	// Update view
	public ArrayList<Equipment> updateView() throws SQLException {
		ArrayList<Equipment> equipList = new ArrayList<Equipment>();
		equipDao edi = new equipDaoiml();
		equipList = (ArrayList<Equipment>) edi.findAll();
		return equipList;
	}
}
