package view;

import java.sql.SQLException;
import java.util.ArrayList;

import GUI.EquipmentGUI;
import GUI.IngredientMantainGUI;
import controller.Controller;
import controller.StorageIngredientController;
import model.Model;
import model.StorageIngredient;

public class StorageIngredientView extends View {
	
	private StorageIngredientController c;
	private StorageIngredient m;
	int visible;
	
	ArrayList<StorageIngredient> sIngredientList = new ArrayList<StorageIngredient>();
	
	public StorageIngredientView(StorageIngredient m, StorageIngredientController c, int visible) throws SQLException {
		super(m, (Controller)c, visible);
		this.m = m;
		this.c = c;
		this.visible = visible;
		sIngredientList = c.updateView();
		IngredientMantainGUI ingreMaintainPage = new IngredientMantainGUI(sIngredientList, c, m);
		// Convert the visibility
		ingreMaintainPage.controlVisible(this.getvisible());
	}
	
	public void update() throws SQLException
	{
		sIngredientList = c.updateView();
		IngredientMantainGUI ingreMaintainPage = new IngredientMantainGUI(sIngredientList, c,m);
		// Convert the visibility
		ingreMaintainPage.controlVisible(this.getvisible());
	}
}
