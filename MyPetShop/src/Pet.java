
public class Pet {
	
	private String type;
	private String breed;
	private double price;
	private boolean extra;
	
	public Pet(String type, String breed, double price, boolean extra) {
		this.type = type;
		this.breed = breed;
		this.price = price;
		this.extra = extra;
	}

	public String getType() {
		return type;
	}
	
	public String getBreed() {
		return breed;
	}

	public double getPrice() {
		return price;
	}
	
	public boolean getExtra() {
		return extra;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	public String toString() {
		return String.format("%-10s%-15s%-20s%-10s$%-13.2f", getType(), "", getBreed(), "", getPrice());
	}
	
}
