package view;

import java.sql.SQLException;

import GUI.EquipmentAddGUI;
import controller.EquipmentController;
import model.Equipment;

public class MaintainRecipeView {
	private EquipmentController c;
	private Equipment m;
	
	public EquipmentAddView(Equipment m, EquipmentController c) throws SQLException {
		this.m = m;
		this.c = c;
		EquipmentAddGUI equipmentAddGUI = new EquipmentAddGUI(m, c);
	}


}
