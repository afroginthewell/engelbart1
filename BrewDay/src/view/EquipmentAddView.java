package view;

import java.sql.SQLException;

import GUI.EquipmentAddGUI;
import GUI.EquipmentGUI;
import controller.EquipmentController;
import model.Equipment;

public class EquipmentAddView {
	private EquipmentController c;
	private Equipment m;
	
	public EquipmentAddView(Equipment m, EquipmentController c) throws SQLException {
		this.m = m;
		this.c = c;
		EquipmentAddGUI equipmentAddGUI = new EquipmentAddGUI(m, c);
	}

}
