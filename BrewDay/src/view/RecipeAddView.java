package view;

import java.sql.SQLException;

import GUI.RecipeAddPageGUI;
import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Recipe;
import model.RecipeIngredient;
import view.View;

public class RecipeAddView extends View{

	
	private RecipeController c;
	private Recipe m;
	int visible;
	private RecipeIngredient i;
	private RecipeIngredientController ic;
	
	
	
	public RecipeAddView(Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic,int visible) throws SQLException {
		super(m, c,visible);
		this.m = m;
		this.c = c;
		this.i=i;
		this.ic=ic;
		this.visible=visible;	
		RecipeAddPageGUI addrecipeGUI = new RecipeAddPageGUI(m,c,i,ic);
		addrecipeGUI.controlVisible(this.getvisible());
	}
	
	
	public void update() throws SQLException
	{
		
		RecipeAddPageGUI addrecipeGUI = new RecipeAddPageGUI(m,c,i,ic);
		addrecipeGUI.controlVisible(this.getvisible());
	}
}
