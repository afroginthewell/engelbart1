package controller;

import model.Equipment;
import view.EquipmentView;

public class EquipmentController {
	
	private Equipment model;
	private EquipmentView view;
	
	// Constructor
	public EquipmentController(Equipment model, EquipmentView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	// Member function
		public boolean updateCapacity(double addCapacityVolumn) {
			
			// Error Handle: Capacity cannot be negative value
			if (model.getCapacity() + addCapacityVolumn < 0)
				return false;
			
			// Update the capacity
			model.setCapacity(model.getCapacity() + addCapacityVolumn); 
			return true;
		}
}
