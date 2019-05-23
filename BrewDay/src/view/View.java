package view;

import java.sql.SQLException;

import controller.Controller;
import controller.RecipeController;
import model.Model;
import model.Recipe;
//father class for all View
public class View {
	private Model m;
	private Controller c;
	int visible;// it is for set whether the View is visible or not
	int index;
	
	public void setindex(int index) throws SQLException
	{
		this.index=index;
	}

	//view cntain model and controller
	public View(Model m, Controller c, int visible) {
		this.m = m;
		this.c = c;
		this.visible = visible;
	}

	

	public void update() throws SQLException {
		// Wait for sub class to fulfill

	}

	public int getvisible() {
		return this.visible;
		// Wait for sub class to fulfill

	}

	public void setvisible(int visible) {
		this.visible = visible;

	}

}
