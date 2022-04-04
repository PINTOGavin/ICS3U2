import java.util.Scanner;
public class changeThatMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		welcome();
		System.out.print("Enter a phrase up to 6 words long: ");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		
		if (countWords(message)>6) {
			System.out.println("Not a valid message. Goodbye!");
			return;
		}
		
		System.out.println("\nHere are your manipulated messages: ");
		System.out.println("UPPER: " + message.toUpperCase());
		System.out.println("lower: " + message.toLowerCase());
		System.out.println("# Words: " + countWords(message) + " words");
		System.out.println("AlTeRnAtInG: " + altCase(message));
		System.out.println("# Vowels: " + countVowels(message) + " vowels");
		System.out.println("vOwEls In UppEr: " + vowelUpper(message));
		
	}
	
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
	}
	
	public static int countWords(String message) {
		int wordCnt = 1;
		for (int i = 0; i<message.length(); i++) {
			if (message.charAt(i)==' ') {
				wordCnt++;
			}
		}
		return wordCnt;
	}
	
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
	}
	
	public static int countVowels(String message) {
		int vowelCnt = 0;
		String messageLower = message.toLowerCase();
		for (int i = 0; i<message.length(); i++) {
			if (messageLower.charAt(i)=='a' || messageLower.charAt(i)=='e' || messageLower.charAt(i)=='i' || messageLower.charAt(i)=='o' || messageLower.charAt(i)=='u') {
				vowelCnt++;
			}
		}
		return vowelCnt;
	}
	
	public static String vowelUpper(String message) {
		String messageLower = message.toLowerCase();
		String newMessage = "";
		for (int i = 0; i<message.length(); i++) {
			char letter = messageLower.charAt(i);
			if (messageLower.charAt(i)=='a' || messageLower.charAt(i)=='e' || messageLower.charAt(i)=='i' || messageLower.charAt(i)=='o' || messageLower.charAt(i)=='u') {
				letter = Character.toUpperCase(letter);
			}
			newMessage = newMessage + letter;
		}
		return newMessage;
	}
	
	public static String reverseMessage(String message) {
		return "";
	}

}
