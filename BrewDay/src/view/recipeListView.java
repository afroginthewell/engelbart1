
package view;

import java.sql.SQLException;
import java.util.ArrayList;

import GUI.DeleteRecipeGUI;
import GUI.RecipeListGUI;
import controller.RecipeController;
import controller.RecipeIngredientController;

import model.Recipe;
import model.RecipeIngredient;
import view.View;

public class recipeListView extends View{

	
	private RecipeController c;
	private Recipe m;
	int visible;
	ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	
	//view for list all recipe
	
	public recipeListView(Recipe m, RecipeController c,int visible) throws SQLException {
		super(m, c,visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
		recipeList=c.updateRecipeView();
		//record all recipe in recipe list
		RecipeListGUI listrecipeGUI = new RecipeListGUI(recipeList,m,c);
		listrecipeGUI.controlVisible(this.getvisible());
	}
	
	
	public void update() throws SQLException
	{
		recipeList=c.updateRecipeView();
		RecipeListGUI listrecipeGUI = new RecipeListGUI(recipeList,m,c);
		listrecipeGUI.controlVisible(this.getvisible());
	}
}