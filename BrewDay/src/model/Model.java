package model;

import java.sql.SQLException;
import java.util.ArrayList;

import view.View;

public class Model {
	ArrayList<View> views;
	
	// Empty constructor
	public Model() {
		views = new ArrayList<View>();
	}
	
	public void addView(View view) {
		views.add(view);
	}
	
	public ArrayList<View> getView()
	{
		return views;
	}
	
	protected void notifyView() throws SQLException {}
}
