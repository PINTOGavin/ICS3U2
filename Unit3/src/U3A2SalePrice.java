import java.util.Scanner;
public class U3A2SalePrice {

	public static void main(String[] args) {

		System.out.println("\n");
		//calls the storeArt method
		storeArt();
		System.out.println("\n");
		//calls the welcome method
		welcome();
		System.out.println();

		//scanner variables
		String pizza1;
		String pizza1Cost;
		String pizza2;
		String pizza2Cost;
		String pizza3;
		String pizza3Cost;

		//string -> int variables
		int cost1;
		int cost2;
		int cost3;
		int costSum;

		//sorted costs
		int lowestCost;
		int middleCost;
		int highestCost;

		//sorted pizza names 
		String lowest;
		String middle;
		String highest;

		//discount off
		double disc;

		//discount off each item
		double discL; 
		double discM;
		double discH;

		//final and total price for each item
		double finalL;
		double finalM;
		double finalH;
		double total;

		Scanner scanner = new Scanner(System.in);

		//asks user input for the 3 pizzas and costs
		System.out.println("Hello what types of pizzas would you like?");
		System.out.print("  Pizza 1: ");
		pizza1 = scanner.nextLine();
		System.out.print("  Pizza 1 Cost: ");
		pizza1Cost = scanner.nextLine();
		System.out.print("  Pizza 2: ");
		pizza2 = scanner.nextLine();
		System.out.print("  Pizza 2 Cost: ");
		pizza2Cost = scanner.nextLine();
		System.out.print("  Pizza 3: ");
		pizza3 = scanner.nextLine();
		System.out.print("  Pizza 3 Cost: ");
		pizza3Cost = scanner.nextLine();

		//changing from string to integer
		cost1 = Integer.parseInt(pizza1Cost);
		cost2 = Integer.parseInt(pizza2Cost);
		cost3 = Integer.parseInt(pizza3Cost);
		costSum = cost1 + cost2 + cost3;

		//checking what discount applies
		if (costSum>=75 || cost1>50 || cost2>50 || cost3>50) {
			disc = 0.3;
			System.out.println("\nYou get a 30% discount on all items!");
		}else if (costSum>30 || cost1>20 || cost2>20 || cost3>30) {
			disc = 0.2;
			System.out.println("\nYou get a 20% discount on all items!");
		}else {
			System.out.println("\nSorry! No discounts are available.");
			disc = 0;
		}

		//sorting the costs into lowest, middle, and highest
		if (cost1>cost2 && cost1>cost3) {
			if (cost2>cost3) {
				middleCost = cost2;
				middle = pizza2;
				lowestCost = cost3;
				lowest = pizza3;
			}else {
				lowestCost = cost2;
				lowest = pizza2;
				middleCost = cost3;
				middle = pizza3;
			}
			highestCost = cost1;
			highest = pizza1;
		}else if (cost2>cost1 && cost2>cost3) {
			if (cost1>cost3) {
				middleCost = cost1;
				middle = pizza1;
				lowestCost = cost3;
				lowest = pizza3;
			}else {
				middleCost = cost3;
				middle = pizza3;
				lowestCost = cost1;
				lowest = pizza1;
			}
			highestCost = cost2;
			highest = pizza2;
		}else { 
			if (cost1>cost2) {
				middleCost = cost1;
				middle = pizza1;
				lowestCost = cost2;
				lowest = pizza2;
			}else {
				lowestCost = cost1;
				lowest = pizza1;
				middleCost = cost2;
				middle = pizza2;
			}
			highestCost = cost3;
			highest = pizza3;
		}

		//calculating $ off for each item
		discL = lowestCost * disc;
		discM = middleCost * disc;
		discH = highestCost * disc;

		//calculating final price for each item
		finalL = lowestCost - discL;
		finalM = middleCost - discM;
		finalH = highestCost - discH;

		//calculating total cost
		total = finalL + finalM + finalH;

		//formatting the values into columns 
		System.out.printf("\n%-15s%-10s%-15s%-10s", "Pizza", "Cost", "Discount", "Final Price");
		System.out.println("\n=====          ====      ========       ===========");
		System.out.printf("%-15s$%-9d$%-14.2f$%-10.2f\n", lowest, lowestCost, discL, finalL);
		System.out.printf("%-15s$%-9d$%-14.2f$%-10.2f\n", middle, middleCost, discM, finalM);
		System.out.printf("%-15s$%-9d$%-14.2f$%-10.2f\n", highest, highestCost, discH, finalH);
		System.out.printf("\n%-40s$%-10.2f\n", "Total:", total);
	} // End main

	//method for ASCII art
	public static void storeArt() {
		System.out.println("                 // \"\"--.._"); 
		System.out.println("                 ||  (_)  _ \"-._");
		System.out.println("                 ||    _ (_)    '-.");
		System.out.println("                 ||   (_)   __..-'");
		System.out.println("                 \\\\__..--\"\"");
	} // End storeArt

	//method for welcome sign
	public static void welcome() {
		System.out.println("   >===========================================<");
		System.out.println("   >        Welcome to Gavin's Pizzeria        <");
		System.out.println("   >===========================================<");
	} // End welcome
} // End class
