package model;
import java.util.ArrayList;
import java.util.Date;

public class Brew {

	private double batchSize; // Record the batch size this brew need
	private String date; // Record the brew time
	private ArrayList<Integer> recommendedRecipeIndex; // Record the recipe recommended in this brew
	private int correspondingNoteIndex; // Record this brew's corrsponding note

	// Constructor
	public Brew(double batchSize, String date) {
		super();
		this.batchSize = batchSize;
		this.date = date;
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

	public ArrayList<Integer> getRecommendedRecipeIndex() {
		return recommendedRecipeIndex;
	}

	public void setRecommendedRecipeIndex(ArrayList<Integer> recommendedRecipeIndex) {
		this.recommendedRecipeIndex = recommendedRecipeIndex;
	}

	public int getCorrespondingNoteIndex() {
		return correspondingNoteIndex;
	}

	public void setCorrespondingNoteIndex(int correspondingNoteIndex) {
		this.correspondingNoteIndex = correspondingNoteIndex;
	}

	
	
}
