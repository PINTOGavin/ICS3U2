
public class PetSummary {
	
	private String type;
	private String breed;
	private int qty;
	private double totalCost;
	private double avgCost;
	
	public PetSummary(String type, String breed) {
		this.type = type;
		this.breed = breed;
		qty = 0;
		totalCost = 0;
	}
	
	public void add(double price) {
		qty++;
		totalCost += price;
		avgCost = totalCost / qty;
	} 
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public double getAvgCost() {
		return avgCost;
	}

	public int getQty() {
		return qty;
	}

	public String getType() {
		return type;
	}

	public String getBreed() {
		return breed;
	}

}
