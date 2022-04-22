import javax.swing.*;
public class U5A4WhosAWinner {

	 public static int showMenu(){
	        Object[] options = {1,2,3,4,5,6,7};
	        Object selectionObject = JOptionPane.showInputDialog(null, "Select One", "How many players?", JOptionPane.PLAIN_MESSAGE, null, options,options[0]);
	        return Integer.parseInt(selectionObject.toString());
	 }
	 public static String userInfo(String infoType) {
		 JFrame frame = new JFrame();
		 
		 return JOptionPane.showInputDialog(frame,infoType);
	 }
	
	public static void main(String[] args) {
		welcome();
		
		System.out.println("\n\n-----Player Info-----\n");
		int players = showMenu();
		String[] names = new String[players];
		int[] wins = new int[players];
		System.out.println("Number of players: " + players + "\n");
		for (int i = 1; i<=players; i++) {
				names[i-1] = userInfo("Player " + i + " name: ").trim();
				wins[i-1] = Integer.parseInt(userInfo("Player " + i + " games won: "));
		}
		String colSize = String.valueOf(-(longestName(names.clone()).length()+3));
		System.out.printf("%"+colSize+"s%s\n", "Player", "Wins");
		System.out.printf("%"+colSize+"s%s\n", "======", "====");
		for (int i = 0; i<players; i++) {
			System.out.printf("%"+colSize+"s%d\n", names[i], wins[i]);
		}
		
		System.out.println("\n-----Statistics-----\n");
		System.out.printf("%s%s\n", "Wins: ", printWins(wins.clone()));
		System.out.printf("%s%d\n", "Most Wins: ", maxValue(wins.clone()));
		System.out.printf("%s%d\n", "Least Wins: ", minValue(wins.clone()));
		System.out.printf("%s%s\n", "Sorted Wins Low to High: ", printWins(sortWinsLow(sortWinsHigh(wins.clone()))));
		System.out.printf("%s%s\n", "Sorted Wins High to Low: ", printWins(sortWinsHigh(wins.clone())));
		System.out.printf("%s%.1f\n", "Average: ", average(wins.clone()));
		System.out.printf("%s%.1f\n", "Median: ", median(sortWinsHigh(wins.clone())));
		System.out.printf("%s%s\n", "Longest Name: ", longestName(names.clone()));
		graphWins(names.clone(),wins.clone());
		
	}
	
	public static void welcome() {
		System.out.printf("%-10s%s","","       o\n");
		System.out.printf("%-10s%s","","    o^/|\\^o\n");
		System.out.printf("%-10s%s",""," o_^|\\/*\\/|^_o\n");
		System.out.printf("%-10s%s","","o\\*`'.\\|/.'`*/o\n");
		System.out.printf("%-10s%s",""," \\\\\\\\\\\\|//////\n");
		System.out.printf("%-10s%s","","  {><><@><><}\n");
		System.out.printf("%-10s%s","","  `\"\"\"\"\"\"\"\"\"`\n");
		System.out.printf("%-3s%s","","Welcome to...WHO'S A WINNER!!!\n");
	}
	
	public static String printWins(int[] wins) {
		StringBuilder winList = new StringBuilder(wins.length*2-1);
		for (int i = 0; i<wins.length; i++) {
			winList.append(wins[i] + (wins.length-i>1 ? "," : ""));
		}
		return winList.toString();
	}
	
	public static int maxValue(int[] wins) {
		return sortWinsHigh(wins)[0];
	}
	
	public static int minValue(int[] wins) {
		return sortWinsLow(sortWinsHigh(wins))[0];
	}
	
	public static int[] sortWinsLow(int[] wins) {
		int[] sortedLow = new int[wins.length];
		for (int i = wins.length-1; i>=0; i--) {
			sortedLow[wins.length-1-i] = wins[i]; 
		}
		return sortedLow;
	}
	
	public static int[] sortWinsHigh(int[] wins) {
		int og;
		for (int i = 0; i<wins.length-1; i++) {
			for (int j = 0; j<wins.length-1; j++) {
				if (wins[j]<wins[j+1]) {
					og = wins[j];
					wins[j] = wins[j+1];
					wins[j+1] = og;
				}
			}
		}
		return wins;
	}
	
	public static double average(int[] wins) {
		double sum = 0;
		for (int i = 0; i<wins.length; i++) {
			sum += wins[i];
		}
		return sum/wins.length;
	}
	
	public static double median(int[] wins) {
		if (wins.length%2==1) {
			return wins[wins.length/2]; 
		}else {
			return average(new int[] {wins[wins.length/2-1],wins[wins.length/2]});
		}
	}
	
	public static String longestName(String[] names) {
		for (int i = 0; i<names.length-1;i++) {
			if (names[i].length()>names[i+1].length()) {
				names[i+1] = names[i];
			}
		}
		return names[names.length-1];
	}
	
	public static void graphWins(String[] names, int[] wins) {
		System.out.println("\n-----Text Graph-----\n");
		String firstColSize = String.valueOf(-(longestName(names.clone()).length()+3));
		String secondColSize = String.valueOf(-(maxValue(wins.clone())+3));
		System.out.printf("%"+firstColSize+"s%"+secondColSize+"s%s\n", "Player Name", "Games Won", "Compared to Average");
		System.out.printf("%"+firstColSize+"s%"+secondColSize+"s%s\n", "===========", "=========", "===================");
		for (int i = 0; i<names.length; i++) {
			StringBuilder winCnt = new StringBuilder(wins[i]);
			for (int j = 0; j<wins[i]; j++) {
				winCnt.append("X");
			}
			
			String sign = wins[i]>=average(wins) ? "+" : "";
			double dif = wins[i]-average(wins);
			System.out.printf("%"+firstColSize+"s%"+secondColSize+"s%s%.1f\n", names[i], winCnt.toString(), sign, dif);
		}
	}
}
