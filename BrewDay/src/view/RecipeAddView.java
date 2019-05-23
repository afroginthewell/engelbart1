package view;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.storageingredientDao;
import Daoiml.storageingredientDaoiml;
import GUI.RecipeAddPageGUI;
import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;
import view.View;

public class RecipeAddView extends View{

	
	private RecipeController c;
	private Recipe m;
	int visible;
	private RecipeIngredient i;
	private RecipeIngredientController ic;
	
	//view for adding recipe
	
	public RecipeAddView(Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic,int visible) throws SQLException {
		super(m, c,visible);
		this.m = m;
		this.c = c;
		this.i=i;
		this.ic=ic;
		this.visible=visible;	
		storageingredientDaoiml sidi = new storageingredientDaoiml();
		ArrayList<StorageIngredient> sIngredientList = new ArrayList<StorageIngredient>();
		sIngredientList=(ArrayList<StorageIngredient>) sidi.findAll();
		//get all storage ingredient and when add recipe, it will consider all ingredient in storagee
		RecipeAddPageGUI addrecipeGUI = new RecipeAddPageGUI(sIngredientList,m,c,i,ic);
		//need controler and model for both recipe and recipe ingredient
		addrecipeGUI.controlVisible(this.getvisible());
	}
	
	
	public void update() throws SQLException
	{
		
		storageingredientDaoiml sidi = new storageingredientDaoiml();
		ArrayList<StorageIngredient> sIngredientList = new ArrayList<StorageIngredient>();
		sIngredientList=(ArrayList<StorageIngredient>) sidi.findAll();
		RecipeAddPageGUI addrecipeGUI = new RecipeAddPageGUI(sIngredientList,m,c,i,ic);
		addrecipeGUI.controlVisible(this.getvisible());
	}
}
