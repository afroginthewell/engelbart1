
package view;
import java.sql.SQLException;
import java.util.ArrayList;
import GUI.RecommendRecipePageGUI;
import GUI.ResultListGUI;
import GUI.UpdataeRecipeGUI;
import GUI.searchGUI;
import controller.BrewController;
import controller.Controller;
import model.Brew;
import model.Model;
import model.RecipeIngredient;

public class searchView extends View{
	Brew m;
	BrewController c=new BrewController(m);
	int visible;
	//view for search
	public searchView(Brew m, BrewController c, int visible) throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
		
		searchGUI sGUI = new searchGUI(m,c);
		
		sGUI.controlVisible(this.getvisible());
	}
	
	
	public void update() throws SQLException
	{
		
		searchGUI sGUI = new searchGUI(m,c);
		sGUI.controlVisible(this.getvisible());
		
	}

}