
package view;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.RecipeIngredientDao;
import Daoiml.RecipeingredientDaoiml;
import GUI.DetailRecipeInformationGUI;
import GUI.RecommendRecipePageGUI;
import GUI.ResultListGUI;
import GUI.UpdataeRecipeGUI;
import controller.BrewController;
import controller.Controller;
import model.Brew;
import model.Model;
import model.RecipeIngredient;

public class detailinfoView extends View{
	Brew m;
	BrewController c=new BrewController(m);
	int visible;
	
	public detailinfoView(Brew m, BrewController c, int visible) throws SQLException {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
		int recipeindex=m.getdetailindex();
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		m.setdetailRecipe((ArrayList<RecipeIngredient>) ri.findbyrecipe(recipeindex));
		
		DetailRecipeInformationGUI detailGUI = new DetailRecipeInformationGUI(m,c);	
		detailGUI.controlVisible(this.getvisible());
	
	}
	
	
	public void update() throws SQLException
	{
		int recipeindex=m.getdetailindex();
		RecipeIngredientDao ri = new RecipeingredientDaoiml();
		m.setdetailRecipe((ArrayList<RecipeIngredient>) ri.findbyrecipe(recipeindex));
		
		DetailRecipeInformationGUI detailGUI = new DetailRecipeInformationGUI(m,c);	
		detailGUI.controlVisible(this.getvisible());
	}

}