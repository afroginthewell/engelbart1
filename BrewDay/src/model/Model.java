package model;

import java.util.ArrayList;

import view.View;
//parent class for all models
public class Model {
	ArrayList<View> views;
	
	// Empty constructor
	public Model() {
		views = new ArrayList<View>();
	}
	
	//add view to model
	public void addView(View view) {
		views.add(view);
	}
	
	//get all view contain in  the model
	public ArrayList<View> getView()
	{
		return views;
	}
}
