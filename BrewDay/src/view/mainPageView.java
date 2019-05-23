

package view;

import java.sql.SQLException;
import java.util.ArrayList;

import GUI.EquipmentGUI;
import GUI.MainpageGUI;
import GUI.MaintainRecipesGUI;
import controller.EquipmentController;
import controller.RecipeController;
import model.Brew;
import model.Equipment;
import model.Recipe;
import model.StorageIngredient;

public class mainPageView{
//view for mainpage
	
	private Recipe r;
	private StorageIngredient s;
	private Equipment e;
	private Brew b;
	int visible;
	
	
	
	public mainPageView(Recipe r, StorageIngredient s,Equipment e,Brew b,int visible) throws SQLException {
		
		this.r = r;
		this.s = s;
		this.e=e;
		this.b=b;
		this.visible=visible;	
		MainpageGUI maitainGUI = new MainpageGUI(r,s,e,b);
		//create mainpage
		
	}

}