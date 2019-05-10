

package view;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.RecipeIngredientDao;
import Daoiml.RecipeingredientDaoiml;
import GUI.DetailRecipeInformationGUI;
import GUI.RecommendRecipePageGUI;
import GUI.ResultListGUI;
import GUI.UpdataeRecipeGUI;
import GUI.shoppinglistGUI;
import controller.BrewController;
import controller.Controller;
import model.Brew;
import model.Model;
import model.RecipeIngredient;

public class shoppinglistView extends View{
	Brew m;
	BrewController c=new BrewController(m);
	int visible;
	
	public shoppinglistView(Brew m, BrewController c, int visible) throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
		int recipeindex=m.getshopindex();
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		m.setShopList((ArrayList<RecipeIngredient>) ri.findbyrecipe(recipeindex));
		c.computeamount(recipeindex, m.getBatchSize());		
		shoppinglistGUI shopGUI = new shoppinglistGUI(m,c);	
		shopGUI.controlVisible(this.getvisible());
	
	}
	
	
	public void update() throws SQLException
	{
		
		int recipeindex=m.getshopindex();
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		m.setShopList((ArrayList<RecipeIngredient>) ri.findbyrecipe(recipeindex));
		c.computeamount(recipeindex, m.getBatchSize());	
		shoppinglistGUI shopGUI = new shoppinglistGUI(m,c);	
		shopGUI.controlVisible(this.getvisible());
	}

}