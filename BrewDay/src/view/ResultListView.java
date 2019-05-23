package view;
import java.sql.SQLException;
import java.util.ArrayList;
import GUI.RecommendRecipePageGUI;
import GUI.ResultListGUI;
import GUI.UpdataeRecipeGUI;
import controller.BrewController;
import controller.Controller;
import model.Brew;
import model.Model;
import model.RecipeIngredient;

public class ResultListView extends View{
	Brew m;
	BrewController c=new BrewController(m);
	int visible;
	
	public ResultListView(Brew m, BrewController c, int visible) throws SQLException {
		//the View for show recommend recipe
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
		double batch=m.getBatchSize();
		c.recommendRecipe(batch);	
		//call controller do recommendation according to batch size
		ResultListGUI resultGUI = new ResultListGUI(m,c);
		resultGUI.controlVisible(this.getvisible());
		
	}
	
	
	public void update() throws SQLException
	{
		double batch=m.getBatchSize();
		c.recommendRecipe(batch);
		ResultListGUI resultGUI = new ResultListGUI(m,c);	
		resultGUI.controlVisible(this.getvisible());
	}

}