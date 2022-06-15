
public class Dog extends Terrestrial{
	
	public Dog(String name, String breed, int age, double price, boolean doesBark) {
		super("Dog", name, breed, age, price, doesBark);
		
	}
	
	public boolean doesBark() {
		return getExtra();
	}
	
	public String toString() {
		return super.toString() + (doesBark() ? "Barks" : "Does Not Bark");
	}
}
