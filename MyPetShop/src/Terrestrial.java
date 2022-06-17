
public class Terrestrial extends Pet{

	private String name;
	private int age;
	
	public Terrestrial(String type, String name, String breed, int age, double price, boolean extra) {
		super(type, breed, price, extra);
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public void isBirthday() {
		age++;
	}
	
	public void adjustAge(int newAge) {
		age = newAge;
	}

	public String toString() {
		return String.format("%-10s%-15s%-20s%-10d$%-13.2f", getType(), getName(), getBreed(), getAge(), getPrice());
	}

}
