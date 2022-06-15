
public class Turtle extends Terrestrial{

	public Turtle(String name, String breed, int age, double price, boolean isFast) {
		super("Turtle", name, breed, age, price, isFast);
	}
	
	public boolean isFast() {
		return getExtra();
	}
	
	public String toString() {
		return super.toString() + (isFast() ? "Fast" : "Slow");
	}
}
