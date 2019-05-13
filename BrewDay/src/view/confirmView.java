


package view;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.RecipeIngredientDao;
import Daoiml.RecipeingredientDaoiml;
import GUI.ConfirmChooseRecipeGUI;
import GUI.DetailRecipeInformationGUI;
import GUI.RecommendRecipePageGUI;
import GUI.ResultListGUI;
import GUI.UpdataeRecipeGUI;
import controller.BrewController;
import controller.Controller;
import model.Brew;
import model.Model;
import model.RecipeIngredient;

public class confirmView extends View{
	Brew m;
	BrewController c=new BrewController(m);
	int visible;
	
	public confirmView(Brew m, BrewController c, int visible) throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
		
		
		ConfirmChooseRecipeGUI cGUI = new ConfirmChooseRecipeGUI(m,c);	
		cGUI.controlVisible(this.getvisible());
	
	}
	
	
	public void update() throws SQLException
	{
		ConfirmChooseRecipeGUI cGUI = new ConfirmChooseRecipeGUI(m,c);	
		cGUI.controlVisible(this.getvisible());
	}

}