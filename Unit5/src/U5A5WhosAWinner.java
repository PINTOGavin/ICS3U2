//Gavin Pinto
//U5A5 - Who's A Winner

import javax.swing.*;
public class U5A5WhosAWinner {

	public static void main(String[] args) {
		//initializing player amount and arrays
		int players = numPlayers();
		String[] names = new String[players];
		int[] wins = new int[players];
		//declaring printf column size
		int col;
		String colSize;
		//declaring invalid variable
		boolean invalid;

		//calling welcome 
		welcome();

		//player info section
		System.out.println("\n\n-----Player Info-----\n");
		//prints number of players
		System.out.println("Number of players: " + players + "\n");
		//asks user for player names and games won
		for (int i = 1; i<=players; i++) {
			while (true) {
				invalid = false;
				names[i-1] = userInfo("Player " + i + " name: ").trim();
				for (int j = 0; j<names[i-1].length(); j++) {
					//invalid input if player name has numbers
					if (Character.isDigit(names[i-1].charAt(j))) {
						error();
						invalid = true;
						break;
					}
				}
				//breaks out of while loop when user enters valid input
				if (!invalid) {
					break;
				}
			}
			while (true) {
				//catches an error if games won is not an int
				try {
					wins[i-1] = Integer.parseInt(userInfo("Player " + i + " games won: "));
					break;
				}catch (Exception e) {
					error();
				}
			}
		}
		//column size is the length of longest name OR as long as length of "Player"+3->(9)
		col = longestName(names.clone()).length()+3;
		if (col<9) {
			col = 9;
		}
		colSize = String.valueOf(-col);
		//prints player names and wins in a table format
		System.out.printf("%"+colSize+"s%s\n", "Player", "Wins");
		System.out.printf("%"+colSize+"s%s\n", "======", "====");
		for (int i = 0; i<players; i++) {
			System.out.printf("%"+colSize+"s%d\n", names[i], wins[i]);
		}

		//stats
		System.out.println("\n-----Statistics-----\n");
		//.clone() is needed to avoid altering the original arrays 
		System.out.printf("%s%s\n", "Wins: ", printWins(wins.clone()));
		System.out.printf("%s%d\n", "Most Wins: ", maxValue(wins.clone()));
		System.out.printf("%s%d\n", "Least Wins: ", minValue(wins.clone()));
		System.out.printf("%s%s\n", "Sorted Wins Low to High: ", printWins(sortWinsLow(sortWinsHigh(wins.clone()))));
		System.out.printf("%s%s\n", "Sorted Wins High to Low: ", printWins(sortWinsHigh(wins.clone())));
		System.out.printf("%s%.1f\n", "Average: ", average(wins.clone()));
		System.out.printf("%s%.1f\n", "Median: ", median(sortWinsHigh(wins.clone())));
		System.out.printf("%s%s\n", "Longest Name: ", longestName(names.clone()));
		graphWins(names.clone(),wins.clone());
	}//End main

	public static void welcome() {
		//draws crown ascii art
		System.out.printf("%-10s%s","","       o\n");
		System.out.printf("%-10s%s","","    o^/|\\^o\n");
		System.out.printf("%-10s%s",""," o_^|\\/*\\/|^_o\n");
		System.out.printf("%-10s%s","","o\\*`'.\\|/.'`*/o\n");
		System.out.printf("%-10s%s",""," \\\\\\\\\\\\|//////\n");
		System.out.printf("%-10s%s","","  {><><@><><}\n");
		System.out.printf("%-10s%s","","  `\"\"\"\"\"\"\"\"\"`\n");
		System.out.printf("%-3s%s","","Welcome to...WHO'S A WINNER!!!\n");
	}//End welcome

	//pop up menu for selecting number of players
	public static int numPlayers(){
		Object[] options = {1,2,3,4,5,6,7};
		Object selectionObject = JOptionPane.showInputDialog(null, "Select One", "How many players?", JOptionPane.PLAIN_MESSAGE, null, options,options[0]);
		return Integer.parseInt(selectionObject.toString());
	}//End numPlayers

	//asks user for input
	public static String userInfo(String infoType) {
		return JOptionPane.showInputDialog(null,infoType);
	}//End userInfo

	//shows pop up for invalid input
	public static void error() {
		JOptionPane.showMessageDialog(null, "Not a valid input. Try again.");
	}//End error

	//prints array in comma separated list
	public static String printWins(int[] wins) {
		StringBuilder winList = new StringBuilder(wins.length*2-1);
		for (int i = 0; i<wins.length; i++) {
			winList.append(wins[i] + (wins.length-i>1 ? "," : ""));
		}
		return winList.toString();
	}//End printWins

	//returns first index of sortWinsHigh
	public static int maxValue(int[] wins) {
		return sortWinsHigh(wins)[0];
	}//End maxValue

	//returns first index of sortWinsLow
	public static int minValue(int[] wins) {
		return sortWinsLow(sortWinsHigh(wins))[0];
	}//End minValue

	//takes in sorted array from high to low and reverses it
	public static int[] sortWinsLow(int[] wins) {
		int[] sortedLow = new int[wins.length];
		for (int i = wins.length-1; i>=0; i--) {
			sortedLow[wins.length-1-i] = wins[i]; 
		}
		return sortedLow;
	}//End sortWinsLow

	//sorts the wins array from high to low
	public static int[] sortWinsHigh(int[] wins) {
		int temp;
		//repeats the nested for loop until array is sorted
		for (int i = 0; i<wins.length-1; i++) {
			//pushes smallest int to the last possible index
			for (int j = 0; j<wins.length-1; j++) {
				if (wins[j]<wins[j+1]) {
					temp = wins[j];
					wins[j] = wins[j+1];
					wins[j+1] = temp;
				}
			}
		}
		return wins;
	}//End sortWinsHigh

	//adds the ints in the wins array and returns average
	public static double average(int[] wins) {
		double sum = 0;
		for (int i = 0; i<wins.length; i++) {
			sum += wins[i];
		}
		return sum/wins.length;
	}//End average

	//takes in sorted array
	public static double median(int[] wins) {
		//returns middle int if array has odd length
		if (wins.length%2==1) {
			return wins[wins.length/2]; 
		}else {
			//returns the average of the middle two elements if array has even length
			return average(new int[] {wins[wins.length/2-1],wins[wins.length/2]});
		}
	}//End median

	//pushes name with largest length to the last index of the array and returns last index
	public static String longestName(String[] names) {
		for (int i = 0; i<names.length-1;i++) {
			if (names[i].length()>names[i+1].length()) {
				names[i+1] = names[i];
			}
		}
		return names[names.length-1];
	}//End longestName

	//text graph
	public static void graphWins(String[] names, int[] wins) {
		int firstCol;
		int secondCol;
		String firstColSize;
		String secondColSize;
		String sign;
		double dif;

		//column size is the length of longest name+3 OR as long as length of "Player Name"+3->(14)
		firstCol = longestName(names.clone()).length()+3;
		if (firstCol<14) {
			firstCol = 14;
		}
		//column size is most wins+3 OR as long as length of "Games Won"+3->(12)
		secondCol = maxValue(wins.clone())+3;
		if (secondCol<12) {
			secondCol = 12;
		}
		//converts to a string with the negative value so it left aligns the column
		firstColSize = String.valueOf(-firstCol);
		secondColSize = String.valueOf(-secondCol);

		System.out.println("\n-----Text Graph-----\n");
		//printing the text labels for each graph column
		System.out.printf("%"+firstColSize+"s%"+secondColSize+"s%s\n", "Player Name", "Games Won", "Compared to Average");
		System.out.printf("%"+firstColSize+"s%"+secondColSize+"s%s\n", "===========", "=========", "===================");
		//iterate through each player's wins
		for (int i = 0; i<names.length; i++) {
			StringBuilder winCnt = new StringBuilder(wins[i]);
			//iterates through the win amount and adds an "X" for each win
			for (int j = 0; j<wins[i]; j++) {
				winCnt.append("X");
			}
			//if the amount of wins if above or equal the average, it adds a "+" sign 
			sign = wins[i]>=average(wins) ? "+" : "";
			//calculates the difference between average and current player's wins
			dif = wins[i]-average(wins);
			//prints player's row stating their name, wins with "X"s, and wins compared to average
			System.out.printf("%"+firstColSize+"s%"+secondColSize+"s%s%.1f\n", names[i], winCnt.toString(), sign, dif);
		}
	}//End graphWins
	
}//End class
