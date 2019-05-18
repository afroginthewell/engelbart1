
package view;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.storageingredientDao;
import Daoiml.RecipeingredientDaoiml;
import Daoiml.storageingredientDaoiml;
import GUI.RecipeAddPageGUI;
import GUI.UpdataeRecipeGUI;
import GUI.recipeingredientDetailGUI;
import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;
import view.View;

public class recipeingredientDetailView extends View{

	
	private RecipeController c;
	private Recipe m;
	int visible;
	private RecipeIngredient i;
	private RecipeIngredientController ic;
	
	

	
	
	public recipeingredientDetailView(Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic,int visible) throws SQLException {
		super(m, c,visible);
		this.m = m;
		this.c = c;
		this.i=i;
		this.ic=ic;
		this.visible=visible;	
		
		ArrayList<RecipeIngredient> sIngredientList = new ArrayList<RecipeIngredient>();
		sIngredientList=ic.GetByRecipe(index);
		
		recipeingredientDetailGUI addrecipeGUI = new recipeingredientDetailGUI(sIngredientList,m,c,i,ic);
		addrecipeGUI.controlVisible(this.getvisible());
	}
	
	
	public void update() throws SQLException
	{
		
		ArrayList<RecipeIngredient> sIngredientList = new ArrayList<RecipeIngredient>();
		sIngredientList=ic.GetByRecipe(index);
		
		recipeingredientDetailGUI addrecipeGUI = new recipeingredientDetailGUI(sIngredientList,m,c,i,ic);
		addrecipeGUI.controlVisible(this.getvisible());
	}
}