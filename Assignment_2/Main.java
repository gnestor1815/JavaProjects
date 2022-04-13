package Assignment_2;

import java.util.*;

public class Main {
	
	public static void main(String [] args) {
		int result = 0;
		boolean isNumber = false;
		
		Scanner in = new Scanner(System.in);
		
		
		do {
			System.out.print("Enter positive integer: ");
			if (in.hasNextInt()) {
				result = in.nextInt();
				isNumber = true;
			} else {
				System.err.println("Not a positive Integer");
				isNumber = true;
				in.next();
			}
		} while (!(isNumber));
		
		System.out.println("Your valid result is " + result);
		in.close();
	}
	
}
