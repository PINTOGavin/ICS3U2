
public class Fish extends Pet{
	
	public Fish (String breed, double price, boolean saltWater) {
		super("Fish", breed, price, saltWater);
	}
	
	public boolean saltWaterFish() {
		return getExtra();
	}
	
	public String toString() {
		return super.toString() + (saltWaterFish() ? "Salt Water" : "Fresh Water");
	}
}
