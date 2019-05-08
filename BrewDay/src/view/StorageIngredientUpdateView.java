package view;

import java.sql.SQLException;
import java.util.ArrayList;

import GUI.EquipmentAddGUI;
import GUI.EquipmentUpdateGUI;
import GUI.IngredientMantainGUI;
import GUI.IngredientUpdateGUI;
import controller.Controller;
import controller.StorageIngredientController;
import model.StorageIngredient;

public class StorageIngredientUpdateView extends View{
	
	private StorageIngredientController c;
	private StorageIngredient m;
	int visible;
	
	ArrayList<StorageIngredient> sIngredientList = new ArrayList<StorageIngredient>();
	

	public StorageIngredientUpdateView(StorageIngredient m, StorageIngredientController c, int visible) throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible = visible;
		sIngredientList = c.updateView();
		IngredientUpdateGUI ingreUpdatePage = new IngredientUpdateGUI(sIngredientList, m, c);
		// Convert the visibility
		ingreUpdatePage.controlVisible(this.getvisible());
	}
	
	public void update() throws SQLException
	{
		
		IngredientUpdateGUI singredientUpdateGUI = new IngredientUpdateGUI(sIngredientList, m,c);
		System.out.println(this.getvisible());
		singredientUpdateGUI.controlVisible(this.getvisible());
	}
	
}
