package view;

import java.sql.SQLException;

import GUI.EquipmentAddGUI;
import GUI.EquipmentGUI;
import controller.EquipmentController;
import model.Equipment;

public class EquipmentAddView extends View{
	private EquipmentController c;
	private Equipment m;
	int visible;
	
	public EquipmentAddView(Equipment m, EquipmentController c, int visible) throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;				
		EquipmentAddGUI equipmentAddGUI = new EquipmentAddGUI(m, c);
		equipmentAddGUI.controlVisible(this.getvisible());
	}
	
	public void update() throws SQLException
	{
		
		EquipmentAddGUI equipmentaddGUI = new EquipmentAddGUI(m,c);
		System.out.println(this.getvisible());
		equipmentaddGUI.controlVisible(this.getvisible());
	}

}
