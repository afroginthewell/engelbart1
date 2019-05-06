package view;

import java.sql.SQLException;
import java.util.ArrayList;

import GUI.EquipmentAddGUI;
import GUI.EquipmentGUI;
import controller.EquipmentController;
import model.Equipment;

public class EquipmentView extends View{
	
	private EquipmentController c;
	private Equipment m;
	int visible;
	
	ArrayList<Equipment> equipList = new ArrayList<Equipment>();
	
	
	public EquipmentView(Equipment m, EquipmentController c,int visible) throws SQLException {
		super(m, c,visible);
		this.m = m;
		this.c = c;
		this.visible=visible;
		equipList=m.updateView();
		EquipmentGUI equipmentGUI = new EquipmentGUI(equipList, c,m);
		equipmentGUI.controlVisible(this.getvisible());
	}
	
	public void update() throws SQLException
	{
		equipList = m.updateView();
//		for(Equipment e:equipList)
//		{
//			System.out.println(e.getName());
//		}
		EquipmentGUI equipmentGUI = new EquipmentGUI(equipList, c,m);
		System.out.println(this.getvisible());
		equipmentGUI.controlVisible(this.getvisible());
	}
	
}
