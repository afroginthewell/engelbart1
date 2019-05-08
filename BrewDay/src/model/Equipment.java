package model;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.equipDao;
import Daoiml.equipDaoiml;
import view.View;

public class Equipment extends Model {
	
	private int equipmentIndex;
	private String name;
	private double capacity;
	//equipDaoiml edi = new equipDaoiml();
	// Constructor
	public Equipment() {
		super();
	}
	
	public Equipment(int equipmentIndex, String name, double capacity) {
		super();
		this.equipmentIndex = equipmentIndex;
		this.name = name;
		this.capacity = capacity;
	}
	
	

	// Getter and Setter for each member variable
	public int getEquipmentIndex() {
		return equipmentIndex;
	}

	public void setEquipmentIndex(int equipmentIndex) {
		this.equipmentIndex = equipmentIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
//	public void addEquipmentToDB(Equipment equipment) throws SQLException
//	{
//		int newEquipIndex = edi.getMaxIndex() + 1;
//		equipment.setEquipmentIndex(newEquipIndex);		
//		edi.add(equipment);
//		
//	}

	public void notifyView() throws SQLException {
		for (View v: super.views) {
			v.update();
		}
	} 
	
	
}