package model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import view.View;

public class Brew extends Model {

	private double batchSize=0; // Record the batch size this brew need
	private String date; // Record the brew date
	private ArrayList<Recipe> recommendedRecipeIndex=new ArrayList<Recipe>(); //record all recipe that can brewed for that batch size
	private ArrayList<Brew> brewhistory=new ArrayList<Brew>(); 	//contain all brew history
	private int correspondingNoteIndex=0; // Record this brew's corrsponding note
	private int inplementRecipeIndex=1;//record the recipe that is been implemented
	private int detailindex=1;//the recipe which you want to see detail information
	private int shopindex=1;
	//the recipe index which you want to see its shopping list
	private int noteindex=1;
	//corresponding note index
	private ArrayList<RecipeIngredient> ingredientList=new ArrayList<RecipeIngredient>();
	//the ingredient list all the recipe you want to see detail
	private ArrayList<RecipeIngredient> notingredientList=new ArrayList<RecipeIngredient>();
	//the corresponding ingredient for non-executable recipe
	private ArrayList<Recipe> notrecommendedRecipeIndex=new ArrayList<Recipe>();
	//the list of recipe which is non-executable for the batch size
	private ArrayList<Double> shopingAmount=new ArrayList<Double>();
	//a double array record the lack amount of each recipeingredient
	
	public int getshopindex() {
		return shopindex;
	}

	public void setshopindex(int shopindex) {
		this.shopindex = shopindex;
	}
	
	public int getnoteindex() {
		return noteindex;
	}

	public void setnoteindex(int noteindex) {
		this.noteindex = noteindex;
	}
	
	public int getdetailindex() {
		return detailindex;
	}

	public void setdetailindex(int detailindex) {
		this.detailindex = detailindex;
	}
	// Constructor
	public Brew() {
		super();
	}

	// Getter and Setter
	public double getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(double batchSize) {
		this.batchSize = batchSize;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<Recipe> getRecommendedRecipeIndex() {
		return recommendedRecipeIndex;
	}

	public void setRecommendedRecipeIndex(ArrayList<Recipe> recommendedRecipeIndex) {
		this.recommendedRecipeIndex = recommendedRecipeIndex;
	}
	
	public ArrayList<Brew> gethistory() {
		return brewhistory;
	}

	public void sethistory(ArrayList<Brew> brewhistory) {
		this.brewhistory = brewhistory;
	}
	
	public ArrayList<Recipe> getnotRecommendedRecipeIndex() {
		return notrecommendedRecipeIndex;
	}

	public void setnotRecommendedRecipeIndex(ArrayList<Recipe> notrecommendedRecipeIndex) {
		this.notrecommendedRecipeIndex = notrecommendedRecipeIndex;
	}

	public int getCorrespondingNoteIndex() {
		return correspondingNoteIndex;
	}

	public void setCorrespondingNoteIndex(int correspondingNoteIndex) {
		this.correspondingNoteIndex = correspondingNoteIndex;
	}

	public void notifyView() throws SQLException {
		for (View v: super.views) {
			v.update();
		}
	}

	public int getInplementRecipeIndex() {
		return inplementRecipeIndex;
	}

	public void setInplementRecipeIndex(int inplementRecipeIndex) {
		this.inplementRecipeIndex = inplementRecipeIndex;
	} 
	
	public ArrayList<RecipeIngredient> getdetailRecipe() {
		return ingredientList;
	}

	public void setdetailRecipe(ArrayList<RecipeIngredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public ArrayList<RecipeIngredient> getShopList() {
		return notingredientList;
	}

	public void setShopList(ArrayList<RecipeIngredient> notingredientList) {
		this.notingredientList = notingredientList;
	}
	
	public ArrayList<Double> getShopingAmount() {
		return shopingAmount;
	}

	public void setShopingAmount(ArrayList<Double> notingredientamount) {
		this.shopingAmount = notingredientamount;
	}
	
	
}
