package model;
public class Equipment {
	private int equipmentIndex;
	private String name;
	private double capacity;

	// Constructor
	public Equipment(int equipmentIndex, String name, double capacity) {
		super();
		this.equipmentIndex = equipmentIndex;
		this.name = name;
		this.capacity = capacity;
	}

	// Getter and Setter for each member variable
	public int getEquipmentIndex() {
		return equipmentIndex;
	}

	public void setEquipmentIndex(int equipmentIndex) {
		this.equipmentIndex = equipmentIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	// Member function
	public boolean updateCapacity(double addCapacityVolumn) {
		if (this.capacity + addCapacityVolumn < 0)
			return false;
		this.capacity = this.capacity + addCapacityVolumn;
		return true;
	}
}