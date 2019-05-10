package view;
import java.sql.SQLException;
import java.util.ArrayList;

import GUI.NotavailableListGUI;
import GUI.RecommendRecipePageGUI;
import GUI.ResultListGUI;
import GUI.UpdataeRecipeGUI;
import controller.BrewController;
import controller.Controller;
import model.Brew;
import model.Model;
import model.RecipeIngredient;

public class notAvailableView extends View{
	Brew m;
	BrewController c=new BrewController(m);
	int visible;
	
	public notAvailableView(Brew m, BrewController c, int visible) throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
	
		NotavailableListGUI notGUI = new NotavailableListGUI(m,c);
		notGUI.controlVisible(this.getvisible());
		
	}
	
	
	public void update() throws SQLException
	{

		NotavailableListGUI notGUI = new NotavailableListGUI(m,c);
		notGUI.controlVisible(this.getvisible());
	}

}