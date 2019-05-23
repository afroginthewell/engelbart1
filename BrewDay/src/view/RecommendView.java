package view;

import java.sql.SQLException;
import java.util.ArrayList;

import GUI.RecommendRecipePageGUI;
import GUI.UpdataeRecipeGUI;
import controller.BrewController;
import controller.Controller;
import model.Brew;
import model.Model;
import model.RecipeIngredient;

public class RecommendView extends View{
	Brew m;
	BrewController c=new BrewController(m);
	int visible;
	
	
	//this page is for What should I brew today
	public RecommendView(Brew m, BrewController c, int visible) {
		super(m, c, visible);
		this.m = m;
		this.c = c;
		this.visible=visible;	
		RecommendRecipePageGUI recomGUI = new RecommendRecipePageGUI(m,c);
		recomGUI.controlVisible(this.getvisible());
		// TODO Auto-generated constructor stub
	}
	
	
	public void update() throws SQLException
	{
		
		RecommendRecipePageGUI recomGUI = new RecommendRecipePageGUI(m,c);
		recomGUI.controlVisible(this.getvisible());
	}

}
