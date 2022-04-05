import java.util.Scanner;
public class U4A4changeThatMessage {

	public static void main(String[] args) {
		//calls welcome
		welcome();
		
		//asks for a phrase and stores in a string
		System.out.print("Enter a phrase up to 6 words long: ");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		
		//checks if string is over 6 words long
		if (countWords(message)>6) {
			System.out.println("Not a valid message. Goodbye!");
			//terminates program
			return;
		}
		
		//manipulates the phrase in different ways
		System.out.println("\nHere are your manipulated messages: ");
		System.out.println("UPPER: " + message.toUpperCase());
		System.out.println("lower: " + message.toLowerCase());
		System.out.println("# Words: " + countWords(message) + " words");
		System.out.println("AlTeRnAtInG: " + altCase(message));
		System.out.println("# Vowels: " + countVowels(message) + " vowels");
		System.out.println("vOwEls In UppEr: " + vowelUpper(message));
		System.out.println("Reverse: " + reverseMessage(message));
		if (message.indexOf(' ')==-1 && message.length()%2==0) {
			System.out.println("Word Stack: \n");
			wordStack(message);
		}else {
			System.out.println("Word Stack not available. Please enter one word that is an even length next time.");
		}
	}//end main
	
	public static void welcome() {
		System.out.println("              ,..........   ..........,");
		System.out.println("          ,..,'          '.'          ',..,");
		System.out.println("         ,' ,'            :            ', ',");
		System.out.println("        ,' ,'             :             ', ',");
		System.out.println("       ,' ,'              :              ', ',");
		System.out.println("      ,' ,'............., : ,.............', ',");
		System.out.println("     ,'  '............   '.'   ............'  ',");
		System.out.println("      '''''''''''''''''';''';''''''''''''''''''");
		System.out.println("                         '''");
		System.out.println("\n       Welcome to the Message Manipulator!");
	}//end welcome
	
	public static int countWords(String message) {
		int wordCnt = 1;
		for (int i = 0; i<message.length(); i++) {
			if (message.charAt(i)==' ') {
				wordCnt++;
			}
		}
		return wordCnt;
	}//end countWords
	
	public static String altCase(String message) {
		String newMessage = "";
		for (int i = 0; i<message.length(); i++) {
			char letter = message.charAt(i);
			if (i%2==0) {
				letter = Character.toUpperCase(letter);
			}else {
				letter = Character.toLowerCase(letter);
			}
			newMessage = newMessage + letter;
		}
		return newMessage;
	}//end altCase
	
	public static int countVowels(String message) {
		int vowelCnt = 0;
		String messageLower = message.toLowerCase();
		for (int i = 0; i<message.length(); i++) {
			char letter = messageLower.charAt(i);
			if (letter=='a' || letter=='e' || letter=='i' || letter=='o' || letter=='u') {
				vowelCnt++;
			}
		}
		return vowelCnt;
	}//countVowels
	
	public static String vowelUpper(String message) {
		String messageLower = message.toLowerCase();
		String newMessage = "";
		for (int i = 0; i<message.length(); i++) {
			char letter = messageLower.charAt(i);
			if (letter=='a' || letter=='e' || letter=='i' || letter=='o' || letter=='u') {
				letter = Character.toUpperCase(letter);
			}
			newMessage = newMessage + letter;
		}
		return newMessage;
	}//end vowelUpper
	
	public static String reverseMessage(String message) {
		String newMessage = "";
		int cnt = message.length()-1;
		while (cnt>=0) {
			newMessage = newMessage + message.charAt(cnt);
			cnt--;
		}
		return newMessage;
	}//end reverseMessage
	
	public static void wordStack(String message) {
		int runs = message.length()/2;
		int spaces = runs-1;
		for (int i = 1; i<=runs; i++) {
			String newMessage = "";
			for (int j = spaces; j>0; j--) {
				newMessage = newMessage + " ";
			}
			newMessage = newMessage + message.substring(runs-i,runs+i);
			System.out.println(newMessage);
			spaces--;
		}
	}//end wordStack
}//end class
