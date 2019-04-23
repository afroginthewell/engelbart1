
public class RecipeIngredient extends Ingredient {
	
	// Constructor
	public RecipeIngredient(String name, double amount, String unit) {
		super(name, amount, unit);
	}
	
	// FUNCTIONS
	boolean updateAmount(double changeAmount) {
		return true;
	}
	
}
