import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PetShop {

	private String name;
	private ArrayList<Pet> dogs = new ArrayList<>();
	private ArrayList<Pet> cats = new ArrayList<>();
	private ArrayList<Pet> turtles = new ArrayList<>();
	private ArrayList<Pet> fishes = new ArrayList<>();
	private ArrayList<Pet> terrestrials = new ArrayList<>();
	private ArrayList<Pet> pets = new ArrayList<>();
	private HashMap<String, PetSummary> petBreeds = new HashMap<>();

	public static void main(String[] args) {
		PetShop shop = new PetShop("PetPals");
		shop.loadPets();
		shop.welcome();
		shop.menu();
	}

	public PetShop(String name) {
		this.name = name;
	}

	//JOptionPane menu options
	public int selectOption(Integer[] options) {
		Object selection = JOptionPane.showInputDialog(null, "Select One", "Options", JOptionPane.PLAIN_MESSAGE, null, options,options[0]);
		return Integer.parseInt(selection.toString());
	}

	public void welcome() {
		System.out.println("\n\n        (\"`-''-/\").___..--''\"`-._ " + 
				"\n         `6_ 6  )   `-.  (     ).`-.__.`)" +
				"\n         (_Y_.)'  ._   )  `._ `. ``-..-' " +
				"\n           _..`--'_..-_/  /--'_.'" +
				"\n          ((((.-''  ((((.'  (((.-'");

		System.out.printf("\n\n%12s%s","","Welcome to " + name + "!\n\n\n");
	}

	public void menu() {
		int selection;
		int animalGroup;
		Integer[] menuOptions = {1,2,3,4,5,6,7,8};
		Integer[] petTypes = {0,1,2,3,4};
		Integer[] terrestrialTypes = {0,1,2,3};

		System.out.println("------------------------------------");
		System.out.println("1) | Display Pets by Type (by Price)");
		System.out.println("------------------------------------");
		System.out.println("2) | Display Pets by Type (by Name)");
		System.out.println("------------------------------------");
		System.out.println("3) | Display Full Animal Inventory");
		System.out.println("------------------------------------");
		System.out.println("4) | Display Inventory Summary");
		System.out.println("------------------------------------");
		System.out.println("5) | Display Top 2 Cheapest Pets");
		System.out.println("------------------------------------");
		System.out.println("6) | Display Top 2 Expensive Pets");
		System.out.println("------------------------------------");
		System.out.println("7) | Display Oldest 3 Pets");
		System.out.println("------------------------------------");
		System.out.println("8) | Display Amount of Pets");
		System.out.println("------------------------------------\n");
		System.out.print("Make a selection: ");
		System.out.println((selection = selectOption(menuOptions)) + "\n");

		switch(selection) {

		case 1:
			System.out.println("Types of Pet: 0 - All Pets | 1 - Dog | 2 - Cat | 3 - Turtle | 4 - Fish");
			System.out.print("\nMake a selection: ");
			System.out.println((animalGroup = selectOption(petTypes)) + "\n");

			switch(animalGroup) {

			case 0:
				printInventory(sortByPrice(pets));
				break;
			case 1:
				printInventory(sortByPrice(dogs));
				break;
			case 2:
				printInventory(sortByPrice(cats));
				break;
			case 3:
				printInventory(sortByPrice(turtles));
				break;
			case 4:
				printInventory(sortByPrice(fishes));
				break;
			default:
				break;
			}
			break;
		//fish don't have names so they are not an option
		case 2:
			System.out.println("Types of Pet: 0 - All Terrestrials | 1 - Dog | 2 - Cat | 3 - Turtle");
			System.out.print("\nMake a selection: ");
			System.out.println((animalGroup = selectOption(terrestrialTypes)) + "\n");

			switch(animalGroup) {

			case 0:
				printInventory(sortByName(terrestrials));
				break;
			case 1:
				printInventory(sortByName(dogs));
				break;
			case 2:
				printInventory(sortByName(cats));
				break;
			case 3:
				printInventory(sortByName(turtles));
				break;
			default:
				break;
			}
			break;
		case 3:
			printInventory(pets);
			break;
		case 4:
			printInventorySummary();
			break;
		case 5:
			System.out.println("Types of Pet: 0 - All Pets | 1 - Dog | 2 - Cat | 3 - Turtle | 4 - Fish");
			System.out.print("\nMake a selection: ");
			System.out.println((animalGroup = selectOption(petTypes)) + "\n");

			switch(animalGroup) {

			case 0:
				printInventory(sortByPrice(pets).subList(0, 2));
				break;
			case 1:
				printInventory(sortByPrice(dogs).subList(0, 2));
				break;
			case 2:
				printInventory(sortByPrice(cats).subList(0, 2));
				break;
			case 3:
				printInventory(sortByPrice(turtles).subList(0, 2));
				break;
			case 4:
				printInventory(sortByPrice(fishes).subList(0,2));
				break;
			default:
				break;
			}
			break;
		case 6:
			System.out.println("Types of Pet: 0 - All Pets | 1 - Dog | 2 - Cat | 3 - Turtle | 4 - Fish");
			System.out.print("\nMake a selection: ");
			System.out.println((animalGroup = selectOption(petTypes)) + "\n");

			switch(animalGroup) {

			case 0:
				printInventory(sortByPrice(pets).subList(pets.size()-2, pets.size()));
				break;
			case 1:
				printInventory(sortByPrice(dogs).subList(dogs.size()-2, dogs.size()));
				break;
			case 2:
				printInventory(sortByPrice(cats).subList(cats.size()-2, cats.size()));
				break;
			case 3:
				printInventory(sortByPrice(turtles).subList(turtles.size()-2, turtles.size()));
				break;
			case 4:
				printInventory(sortByPrice(fishes).subList(fishes.size()-2, fishes.size()));
				break;
			default:
				break;
			}
			break;
		//fish don't have ages so they are not an option
		case 7:
			System.out.println("Types of Pet: 0 - All Terrestrials | 1 - Dog | 2 - Cat | 3 - Turtle");
			System.out.print("\nMake a selection: ");
			System.out.println((animalGroup = selectOption(terrestrialTypes)) + "\n");

			switch(animalGroup) {

			case 0:
				printInventory(sortByAge(terrestrials).subList(terrestrials.size()-3, terrestrials.size()));
				break;
			case 1:
				printInventory(sortByAge(dogs).subList(dogs.size()-3, dogs.size()));
				break;
			case 2:
				printInventory(sortByAge(cats).subList(cats.size()-3, cats.size()));
				break;
			case 3:
				printInventory(sortByAge(turtles).subList(turtles.size()-3, turtles.size()));
				break;
			default:
				break;
			}
			break;
		case 8:
			System.out.println("Types of Pet: 0 - All Pets | 1 - Dog | 2 - Cat | 3 - Turtle | 4 - Fish");
			System.out.print("\nMake a selection: ");
			System.out.println((animalGroup = selectOption(petTypes)) + "\n");

			switch(animalGroup) {

			case 0:
				System.out.println("There are " + quantity(pets) + " pets.");
				break;
			case 1:
				System.out.println("There are " + quantity(dogs) + " dogs.");
				break;
			case 2:
				System.out.println("There are " + quantity(cats) + " cats.");
				break;
			case 3:
				System.out.println("There are " + quantity(turtles) + " turtles.");
				break;
			case 4:
				System.out.println("There are " + quantity(fishes) + " fish.");
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}


	}

	public void loadPets() {
		String filePath = "src/PetInventory.csv";
		String line="";
		String values[];
		String petType;
		String name;
		String breed;
		int age;
		double price;
		boolean extra;

		//loading pets from the csv file
		try {
			Scanner input = new Scanner(new File(filePath));
			boolean isFirstLine = true;
			while(input.hasNext()) {

				line = input.nextLine();
				if (isFirstLine) {
					isFirstLine = false;
					continue;
				}
				// Split into an Array of Values based on Comma
				values = line.split(",");
				// Print the Line
				petType = values[0];
				name = values[1];
				breed = values[2];
				age = (!"".equals(values[3]) ? Integer.parseInt(values[3]) : -1);
				price = Double.parseDouble(values[4]);
				extra = Boolean.parseBoolean(values[5].toLowerCase());

				switch(petType) {
				case "Dog":
					dogs.add(new Dog(name,breed,age,price,extra));
					break;

				case "Cat":
					cats.add(new Cat(name,breed,age,price,extra));
					break;

				case "Turtle":
					turtles.add(new Turtle(name,breed,age,price,extra));
					break;

				case "Fish":
					fishes.add(new Fish(breed,price,extra));
					break;

				default:
					System.out.println("Error in file: Pet type not valid!");
					break;
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

		terrestrials.addAll(dogs);
		terrestrials.addAll(cats);
		terrestrials.addAll(turtles);
		pets.addAll(terrestrials);
		pets.addAll(fishes);
		
		// Loading Summary HashMaps
		PetSummary info;
		for (Pet pet : pets) {
			//if breed doesn't exist yet, it creates a PetSummary object
			info = petBreeds.getOrDefault(pet.getBreed(), new PetSummary(pet.getType(),pet.getBreed()));
			//inserts the key value pair of breed + PetSummary object
			petBreeds.put(pet.getBreed(),info);
			//adds 1 to the quantity of the PetSummary object
			System.out.println(pet.getBreed() + pet.getPrice());
			info.add(pet.getPrice());
		}

	}

	public ArrayList<Pet> sortByPrice(ArrayList<Pet> arrToSort) {
		ArrayList<Pet> sorted = new ArrayList<>();

		for (int i = 0; i<arrToSort.size(); i++) {
			sorted.add(arrToSort.get(i));
		}

		for (int i = 0; i<sorted.size()-1; i++) {
			for (int j = 0; j<sorted.size()-1; j++) {
				if (sorted.get(j).getPrice()>sorted.get(j+1).getPrice()) {
					Collections.swap(sorted, j, j+1);
				}
			}
		}

		return sorted;
	}

	public ArrayList<Pet> sortByName(ArrayList<Pet> arrToSort) {
		ArrayList<Pet> sorted = new ArrayList<>();

		for (int i = 0; i<arrToSort.size(); i++) {
			sorted.add(arrToSort.get(i));
		}

		for (int i = 0; i<sorted.size()-1; i++) {
			for (int j = 0; j<sorted.size()-1; j++) {
				String curName = ((Terrestrial) sorted.get(j)).getName();
				String nextName = ((Terrestrial) sorted.get(j+1)).getName();
				if (curName.compareToIgnoreCase(nextName) > 0) {
					Collections.swap(sorted, j, j+1);
				}
			}
		}

		return sorted;
	}

	public ArrayList<Pet> sortByAge(ArrayList<Pet> arrToSort) {
		ArrayList<Pet> sorted = new ArrayList<>();

		for (int i = 0; i<arrToSort.size(); i++) {
			sorted.add(arrToSort.get(i));
		}

		for (int i = 0; i<sorted.size()-1; i++) {
			for (int j = 0; j<sorted.size()-1; j++) {
				int curAge = ((Terrestrial) sorted.get(j)).getAge();
				int nextAge = ((Terrestrial) sorted.get(j+1)).getAge();
				if (curAge > nextAge) {
					Collections.swap(sorted, j, j+1);
				}
			}
		}

		return sorted;
	}

	public void printInventory(List<Pet> pets) {
		String header = String.format("%-10s%-15s%-20s%-10s%-14s%-15s", "Type", "Name", "Breed", "Age", "Price", "Extra");
		System.out.println(header);
		for (int i = 0; i<header.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
		for (Pet pet : pets) {
			System.out.println(pet);
		}
	}

	public void printInventorySummary() {
		System.out.printf("%-10s%-25s%-10s%s", "Type", "Breed", "Amount", "Average Price");
		System.out.println("\n==========================================================\n");
		for (String breed : petBreeds.keySet()) {
			System.out.printf("%-10s%-25s%-10d$%.2f\n", petBreeds.get(breed).getType(), breed, petBreeds.get(breed).getQty(), petBreeds.get(breed).getAvgCost());
		}
		
	}

	public int quantity(ArrayList<Pet> arr) {
		return arr.size();
	}

}
