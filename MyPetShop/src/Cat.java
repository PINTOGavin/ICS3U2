
public class Cat extends Terrestrial{
	
	public Cat(String name, String breed, int age, double price, boolean houseCat) {
		super("Cat", name, breed, age, price, houseCat);
	}
	
	public boolean isHouseCat() {
		return getExtra();
	}
	
	public String toString() {
		return super.toString() + (isHouseCat() ? "House Cat" : "Not A House Cat");
	}
}
