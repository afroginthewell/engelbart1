
package view;
import java.sql.SQLException;
import java.util.ArrayList;
import GUI.DeleteRecipeGUI;
import GUI.UpdateGUI;
import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Recipe;
import model.RecipeIngredient;
import view.View;

public class UpdateRecipeView extends View{

	
	private RecipeController c;
	private Recipe m;
	int visible;
	private RecipeIngredient i;
	private RecipeIngredientController ic;
	ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	
	//View for update ingredient for one recipe
	
	public UpdateRecipeView(Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic,int visible) throws SQLException {
		super(m, c,visible);
		this.m = m;
		this.c = c;
		this.i=i;
		this.ic=ic;
		this.visible=visible;	
		recipeList=c.updateRecipeView();
		
		UpdateGUI uprecipeGUI = new UpdateGUI(recipeList,m,c,i,ic);
		//need controler and model for both recipe and recipe ingredient
		uprecipeGUI.controlVisible(this.getvisible());
	}
	
	
	public void update() throws SQLException
	{
		recipeList=c.updateRecipeView();
		UpdateGUI uprecipeGUI = new UpdateGUI(recipeList,m,c,i,ic);
		uprecipeGUI.controlVisible(this.getvisible());
	}
}