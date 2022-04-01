//Gavin Pinto
//U4A1 - My Paint Store Loops

import java.util.Scanner;
public class U4A1MyPaintStoreLoops {
	
	//dog ascii art
	static String[] dog = {
		 "    |\\|\\            ",
		 "   ..    \\       .  ",
		 " o--     \\\\    / @) ",
		 "  v__///\\\\\\\\__/ @   ",
		 "    {           }   ",
		 "     {  } \\\\\\{  }   ",
		 "     <_|      <_|   "
		};
	
	//same string length as dog
	static String blankSpace = "                    ";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//calls welcome
		welcome();
		//asks for user choice 1-6
		System.out.print("Your selection: ");
		int choice = scanner.nextInt(); 
		//init and declares # of dogs
		int amt = 0;
		
		//determines option based on user input
		switch (choice) {
			//quit
			case 0:
				System.out.println("Goodbye!");
				break;
			//rectangle
			case 1: 
				int inputRectRows,inputRectColumns;
				System.out.print("Enter the amount of rows: ");
				inputRectRows = scanner.nextInt();
				System.out.print("Enter the amount of columns: ");
				inputRectColumns = scanner.nextInt();
				amt = inputRectRows * inputRectColumns;
				System.out.println("You will require " + amt + " dogs.\n");
				//draws rectangle display
				rectangle(inputRectRows,inputRectColumns);
				break;
			//normal pyramid
			case 2:
				int inputPyrRows;
				System.out.print("Enter the amount of rows: ");
				inputPyrRows = scanner.nextInt();
				amt = inputPyrRows * inputPyrRows;
				System.out.println("You will require " + amt + " dogs.\n");
				//draws pyramid display
				pyramid(inputPyrRows);
				break;
			//inverted pyramid
			case 3:
				int inputPyrDownRows;
				System.out.print("Enter the amount of rows: ");
				inputPyrDownRows = scanner.nextInt();
				amt = inputPyrDownRows * inputPyrDownRows;
				System.out.println("You will require " + amt + " dogs.\n");
				//draws inverted pyramid display
				pyramidDown(inputPyrDownRows,false);
				break;
			//diamond
			case 4: 
				int inputDiaRows;
				System.out.print("Enter the ODD amount of rows: ");
				inputDiaRows = scanner.nextInt();
				//checks if the input is odd
				if (inputDiaRows%2==0) {
					System.out.println("Sorry. Even numbers will not work.");
				}else {
					amt = (inputDiaRows * inputDiaRows + 1)/2; 
					System.out.println("You will require " + amt + " dogs.\n");
					//draws diamond display
					diamond(inputDiaRows);
				}
				
				break;
			//signature row
			case 5:
				int inputRowVal;
				System.out.print("Enter the number of dogs: ");
				inputRowVal = scanner.nextInt();
				System.out.println("The dogs can be arranged " + sigRowArrWays(inputRowVal) + " ways.");
				break;
			//myX
			case 6:
				int inputWidthVal;
				int inputHeightVal;
				System.out.print("Enter the ODD width of the X shape: ");
				inputWidthVal = scanner.nextInt();
				System.out.print("Enter the ODD height of the X shape: ");
				inputHeightVal = scanner.nextInt();
				//checks if input is odd or under 3
				if (inputHeightVal%2==0 || inputWidthVal%2==0 || inputHeightVal < 3 || inputWidthVal < 3) {
					System.out.println("Sorry. These numbers will not work.");
					break;
				}
				//checks if X width=height and calculates amount of dogs
				if (inputWidthVal == inputHeightVal) {
					if (inputWidthVal==0) {
						amt = 0;
					}else {
						amt = inputWidthVal * 2 - 1;
					}
				}else {
					amt = 5;
				}
				System.out.println("You will need " + amt + " dogs.\n");
				//draws X display
				myX(inputWidthVal, inputHeightVal);
				break;
			//choice not valid
			default:
				System.out.println("Not a valid option. Goodbye!");
		}
	}//end main
	
	public static void welcome() {
		System.out.println();
		//draws the dog ascii art
		int cnt = 0;
		do {
			System.out.println("     " + dog[cnt]);
			cnt++;
		}while (cnt < dog.length);
		//prints the welcome sign and options
		System.out.println("\n    =====================");
		System.out.println("     Welcome to DogStax!");
		System.out.println("    =====================\n");
		System.out.println("Please select an option or '0' to quit.\n");
		System.out.println("     1) Rectangle dog display");
		System.out.println("     2) Pyramid dog display");
		System.out.println("     3) Inverted Pyramid dog display");
		System.out.println("     4) Diamond dog display");
		System.out.println("     5) Signature Row Arrangement Ways");
		System.out.println("     6) X-Shape dog display\n");
	}//end welcome
	
	public static void rectangle(int rows, int columns) {
		//controls the amt of rows
	    for (int i = 0; i < rows; i++) {
	    	//controls drawing ascii art
	    	for (int j = 0; j < dog.length; j++) {
	    		//controls the amt of columns
				for (int k = 0; k < columns; k++) {
					System.out.print(dog[j]);
				}
				System.out.println();
	    	}
			System.out.println();
	    }
	}//end rectangle
	
	public static void pyramid(int rows) {
		int largestRowValue = rows * 2 - 1;
		int currentRowValue;
		int blankSpaceCheck;
		//controls amt of rows
		for (int i = 1; i <= rows; i++) {
			//checks the amt of dogs on current row
			currentRowValue = i * 2 - 1;
			//checks if nothing should be drawn
			blankSpaceCheck = (largestRowValue - currentRowValue)/2;
			//controls drawing ascii art
			for (int j = 0; j < dog.length; j++) {
				//controls width of pyramid
				for (int k = 1; k <= largestRowValue; k++) {
					//checks if nothing should be drawn or ascii art
					if (k <= blankSpaceCheck || k > largestRowValue - blankSpaceCheck) {
						System.out.print(blankSpace);
					}else {
						System.out.print(dog[j]);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}//end pyramid
	
	public static void pyramidDown(int rows, boolean isDiamond) {
		int largestRowValue = rows * 2 - 1;
		int currentRowValue;
		int blankSpaceCheck;
		int cnt1 = rows;
		//controls amt of rows
		while (cnt1 > 0) {
			currentRowValue = cnt1 * 2 - 1;
			blankSpaceCheck = (largestRowValue - currentRowValue)/2;
			int cnt2 = 0;
			//controls ascii art
			while (cnt2 < dog.length) {
				int cnt3 = largestRowValue;
				//if diamond = true then offset entire pyramid by one space
				if (isDiamond) {
					System.out.print(blankSpace);
				}
				//controls width of pyramid
				while (cnt3 > 0) {
					if (cnt3 <= blankSpaceCheck || cnt3 > largestRowValue - blankSpaceCheck) {
						System.out.print(blankSpace);
					}else {
						System.out.print(dog[cnt2]);
					}
					cnt3--;
				}
				System.out.println();
				cnt2++;
			}
			System.out.println();
			cnt1--;
		}
	}//end pyramidDown
	
	public static void diamond(int rows) {
		//pyramid draws top half of diamond
		pyramid((rows+1)/2);
		//inverted pyramid finishes the diamond
		pyramidDown((rows-1)/2,true);
	}//end diamond
	
	public static int sigRowArrWays(int rowAmt) {
		//calculates factorial of rows variable
		int product = 1;
		//0! will return 0
		if (rowAmt == 0) {
			return rowAmt;
		}
		for (int i = rowAmt; i > 0; i--) {
			product *= i; 
		}
		return product;
	}//end sigRowArrWays

	public static void myX(int width, int height ) {
		//if width=height then draws dog(s) on every row
		if (width==height) {
			for (int i = 1; i <= height; i++) {
				for (int j = 0; j < dog.length; j++) {
					for (int k = 1; k <= width; k++) {
						//k==i checks top left to bottom right
						//k+i==width+1 checks top right to bottom left
						if (k == i || k+i == width+1) {
							System.out.print(dog[j]);
						}else {
							System.out.print(blankSpace);
						}
					}
					System.out.println();
				}
				System.out.println();
			}
		//if width and height are different then it draws 4 corners and center
		}else {
			for (int i = 1; i <= height; i++) {
				for (int j = 0; j < dog.length; j++) {
					for (int k = 1; k <= width; k++) {
						//left OR STATEMENT checks for corners
						//right OR STATEMENT checks for center
						if (((i==1 || i==height) && (k==1 || k==width)) || (i==(height+1)/2 && k==(width+1)/2)) {
							System.out.print(dog[j]);
						}else {
							System.out.print(blankSpace);
						}
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}//end myX
}//end class
