import java.util.ArrayList;
import java.util.Date;

public class Brew {

	private double batchSize; // Record the batch size this brew need
	private Date date; // Record the brew time
	private ArrayList<Integer> recommendedRecipeIndex; // Record the recipe recommended in this brew
	private int correspondingNoteIndex; // Record this brew's corrsponding note

	// Constructor
	public Brew(double batchSize, Date date, ArrayList<Integer> recommendedRecipeIndex, int correspondingNoteIndex) {
		super();
		this.batchSize = batchSize;
		this.date = date;
		this.recommendedRecipeIndex = recommendedRecipeIndex;
		this.correspondingNoteIndex = correspondingNoteIndex;
	}

	// Getter and Setter
	public double getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(double batchSize) {
		this.batchSize = batchSize;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	// FUNCTIONS
	public boolean implement(Recipe recipe, double batchSize, Equipment equipment) {
		// Error handle: If batch size is smaller than 0, reject
		if (batchSize <= 0)
			return false;

		// Error handle: If batch size is larger than avaliable capacity, reject
		if (getCapacity(equipment) < batchSize) {
			return false;
		}
		
		// Convert recipe's percentage to absolute
		
		
		// Write the note
		
		return true;
	}
	
	public ArrayList<Recipe> recommendRecipe(double batchSize){
		ArrayList<Recipe> rRecipeList = new ArrayList<Recipe>();
		return rRecipeList;
	}
	
	public double getCapacity(Equipment equipment) {
		return equipment.getCapacity();
	}
	
}
