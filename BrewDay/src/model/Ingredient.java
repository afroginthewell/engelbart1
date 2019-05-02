package model;

public class Ingredient {
	private int index;
	private String name;
	private double amount;
	private String unit;
	
	// Constructor
	public Ingredient(int index, String name, double amount, String unit) {
		this.index = index;
		this.name = name;
		this.amount = amount;
		this.unit = unit;
	}
	
	// Getter and Setter	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getindex() {
		return index;
	}

	public void setindex(int index) {
		this.index = index;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
