package view;

import java.sql.SQLException;
import java.util.ArrayList;

import GUI.EquipmentGUI;
import GUI.MaintainRecipesGUI;
import controller.EquipmentController;
import controller.RecipeController;
import model.Equipment;
import model.Recipe;

public class MaitainRecipesView extends View{

	
	private RecipeController c;
	private Recipe m;
	int visible;
	
	
	
	public MaitainRecipesView(Recipe m, RecipeController c,int visible) throws SQLException {
		super(m, c,visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
		MaintainRecipesGUI maitainGUI = new MaintainRecipesGUI(m,c);
		maitainGUI.controlVisible(this.getvisible());
	}
	
	
	public void update() throws SQLException
	{
		
		MaintainRecipesGUI maitainGUI = new MaintainRecipesGUI(m,c);	
		maitainGUI.controlVisible(this.getvisible());
	}
}
