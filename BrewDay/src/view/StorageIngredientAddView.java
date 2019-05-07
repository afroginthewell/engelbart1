package view;

import java.sql.SQLException;
import java.util.ArrayList;

import GUI.IngredientAddGUI;
import GUI.IngredientUpdateGUI;
import controller.Controller;
import controller.StorageIngredientController;
import model.Model;
import model.StorageIngredient;

public class StorageIngredientAddView extends View {

	private StorageIngredientController c;
	private StorageIngredient m;
	int visible;
	ArrayList<StorageIngredient> sIngredientList = new ArrayList<StorageIngredient>();

	public StorageIngredientAddView(StorageIngredient m, StorageIngredientController c, int visible)
			throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible = visible;
		sIngredientList = c.updateView();
		IngredientAddGUI ingreUpdatePage = new IngredientAddGUI(sIngredientList, c, m);
		// Convert the visibility
		ingreUpdatePage.controlVisible(this.getvisible());
	}

}
