//Gavin Pinto
//U4A4 - Change That Message

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
		//printf formats the options into organized and aligned columns
		System.out.printf("   %-20s%-1s\n","UPPER: ",message.toUpperCase());
		System.out.printf("   %-20s%-1s\n","lower: ",message.toLowerCase());
		System.out.printf("   %-20s%-1d%-1s\n","# Words: ",countWords(message)," words");
		System.out.printf("   %-20s%-1s\n","AlTeRnAtInG: ",altCase(message));
		System.out.printf("   %-20s%-1d%-1s\n","# Vowels: ",countVowels(message)," vowels");
		System.out.printf("   %-20s%-1s\n","vOwEls In UppEr: ",vowelUpper(message));
		System.out.printf("   %-20s%-1s\n","Reverse: ",reverseMessage(message));
		System.out.printf("   %-20s%-1d\n","# 'be's and 'the's: ",countTheBes(message));
		//checks for single word........checks for even length
		if (message.indexOf(' ')==-1 && message.length()%2==0) {
			System.out.println("\nWord Stack: \n");
			wordStack(message);
		}else {
			System.out.println("\nWord Stack not available. Please enter one word that is an even length next time.");
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
		int wordCnt = 0;
		//removes spaces at the beginning and end
		String messageTrim = message.trim();
		if (messageTrim.length()==0) {
			return 0;
		}else {
			wordCnt++;
		}
		for (int i = 0; i<messageTrim.length(); i++) {
			//if there are multiple spaces in a row, it doesn't run the code after
			if (i>0 && messageTrim.charAt(i-1)==' ') {
				continue;
			}
			//checks for space to increase wordCnt
			if (messageTrim.charAt(i)==' ') {
				wordCnt++;
			}
		}
		return wordCnt;
	}//end countWords
	
	public static String altCase(String message) {
		StringBuilder newMessage = new StringBuilder(message.length());
		for (int i = 0; i<message.length(); i++) {
			char letter = message.charAt(i);
			//even index - uppercase
			if (i%2==0) {
				letter = Character.toUpperCase(letter);
			//odd index
			}else {
				letter = Character.toLowerCase(letter);
			}
			newMessage.append(letter);
		}
		return newMessage.toString();
	}//end altCase
	
	public static int countVowels(String message) {
		int vowelCnt = 0;
		String messageLower = message.toLowerCase();
		for (int i = 0; i<message.length(); i++) {
			char letter = messageLower.charAt(i);
			//increases vowelCnt if char is a vowel
			if (letter=='a' || letter=='e' || letter=='i' || letter=='o' || letter=='u') {
				vowelCnt++;
			}
		}
		return vowelCnt;
	}//countVowels
	
	public static String vowelUpper(String message) {
		String messageLower = message.toLowerCase();
		StringBuilder newMessage = new StringBuilder (message.length());
		//runs through the message
		for (int i = 0; i<message.length(); i++) {
			char letter = messageLower.charAt(i);
			//checks for vowel
			if (letter=='a' || letter=='e' || letter=='i' || letter=='o' || letter=='u') {
				letter = Character.toUpperCase(letter);
			}
			//adds char to new message
			newMessage.append(letter);
		}
		return newMessage.toString();
	}//end vowelUpper
	
	public static String reverseMessage(String message) {
		StringBuilder newMessage = new StringBuilder(message.length());
		int cnt = message.length()-1;
		//reverse while loop runs through OG message backwards
		while (cnt>=0) {
			//adds the char from OG message to new message
			newMessage.append(message.charAt(cnt));
			cnt--;
		}
		return newMessage.toString();
	}//end reverseMessage
	
	public static int countTheBes(String message) {
		//converts to lowercase
		String messageLower = message.toLowerCase();
		int theBeCnt = 0;
		//counts all "be"
		int idx = messageLower.indexOf("be");
		while (idx != -1) {
			theBeCnt ++;
			idx = messageLower.indexOf("be",idx+2);
		}
		//counts all "the"
		idx = messageLower.indexOf("the");
		while (idx != -1) {
			theBeCnt ++;
			idx = messageLower.indexOf("the",idx+3);
		}
		//returns total #
		return theBeCnt;
	}//end countTheBes
	
	public static void wordStack(String message) {
		//# of rows
		int runs = message.length()/2;
		//spaces before top row
		int spaces = runs+2;
		//prints each row
		for (int i = 1; i<=runs; i++) {
			StringBuilder newMessage = new StringBuilder();
			//prints spaces
			for (int j = spaces; j>0; j--) {
				newMessage.append(" ");
			}
			//adds substring to spaces
			newMessage.append(message.substring(runs-i,runs+i));
			System.out.println(newMessage);
			spaces--;
		}
	}//end wordStack

}//end class
