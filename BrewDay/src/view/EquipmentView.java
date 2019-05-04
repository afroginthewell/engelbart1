package view;

import java.sql.SQLException;

import GUI.EquipmentGUI;
import controller.EquipmentController;
import model.Equipment;

public class EquipmentView {
	private EquipmentController c;
	private Equipment m;
	public EquipmentView(Equipment m, EquipmentController c) throws SQLException {
		this.m = m;
		this.c = c;
		EquipmentGUI equipmentGUI = new EquipmentGUI(m, c);
	}
}
