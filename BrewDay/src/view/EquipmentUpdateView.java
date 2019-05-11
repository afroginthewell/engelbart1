
package view;

import java.sql.SQLException;

import GUI.EquipmentAddGUI;
import GUI.EquipmentGUI;
import GUI.EquipmentUpdateGUI;
import controller.EquipmentController;
import model.Equipment;

public class EquipmentUpdateView extends View{
	private EquipmentController c;
	private Equipment m;
	int visible;
	
	public EquipmentUpdateView(Equipment m, EquipmentController c, int visible) throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;				
		EquipmentUpdateGUI equipmentUpdateGUI = new EquipmentUpdateGUI(m,c);
		equipmentUpdateGUI.controlVisible(this.getvisible());
	}
	
	public void update() throws SQLException
	{
		
		EquipmentUpdateGUI equipmentUpdateGUI = new EquipmentUpdateGUI(m,c);
		equipmentUpdateGUI.controlVisible(this.getvisible());
	}

}
