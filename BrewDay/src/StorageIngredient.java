
public class StorageIngredient extends Ingredient {
	
	// Constructor
	public StorageIngredient(String name, double amount, String unit) {
		super(name, amount, unit);
	}
	
	// FUNCTIONS
	public boolean addAmount(int ingredientIndex, double amount) {
		return true;
	}
	
	public boolean subtractAmount(int ingredientIndex, double amount) {
		return true;
	}
}
