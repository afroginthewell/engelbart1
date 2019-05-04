package view;

import GUI.EquipmentGUI;
import controller.EquipmentController;
import model.Equipment;

public class EquipmentView {
	private EquipmentController c;
	private Equipment m;
	public EquipmentView() {
		EquipmentGUI equipmentGUI = new EquipmentGUI(m, c);
	}
}
