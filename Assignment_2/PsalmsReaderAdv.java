package Assignment_2;

import java.io.File;
import java.util.Scanner;

public class PsalmsReaderAdv {
	static int x = 1;
	static String chaptSelect = null;
	static String verSelect = null;
	public static void main(String [] args){
		do {
		runProgram();
		} while (x == 1);

	
	}
	
	
	private static String getReference(String inLine) {
		String ref = "";
		String[] ref2 = inLine.split("	");
		ref = ref2[0];
		return ref;
	}
	
	private static String getVerse(String inLine) {
		String ver = "";
		String[] ver2 = inLine.split("	");
		ver = ver2[1];
		return ver;
	}
	
	private static void runProgram() {
		Scanner input = new Scanner(System.in);
		x = 0;
		System.out.println("What Book of Psalms chapter?: ");
		String chaptNum = input.nextLine();
		chaptSelect = chaptNum.replaceAll("[^0-9]", "");
		if (chaptNum.isEmpty()) {
			System.out.println("Thank you for reading the book of psalms!");
			System.exit(0);
		} else if (chaptSelect.isEmpty()) {
			System.out.println("Please use positive integers only");
			System.exit(0);
		} else if (chaptNum.contains("-")) {
			System.out.println("Please use positive integers only.");
			System.exit(0);
		} 
		System.out.println("What Book of Psalms verse within the chapter? : ");
		int verseNum = input.nextInt();
		verSelect = Integer.toString(verseNum);
		if (verSelect.isEmpty()) {
			System.out.println("Please use positive integers only");
			System.exit(0);
		} else if (verseNum <= 0) {
			System.out.println("Please use positive integers only.");
			System.exit(0);
		} 
		
	try { 
		
		Scanner inputFile = new Scanner (new File("bible-psalms.txt"));
		
		int printTimes = 0;
		
		while (inputFile.hasNextLine()) {
			String inLine = inputFile.nextLine();
			String chapAndVer = inLine.substring(6, 12).strip();
			String[] inLineFind = (chapAndVer.split(":"));
			String inVer = inLineFind[1].replaceAll("[^0-9]", "");
			if (chaptSelect.equals(inLineFind[0]) && verSelect.equals(inVer)) {
			System.out.println(getReference(inLine));
			System.out.print(" " + getVerse(inLine));
			printTimes = 1;
			}
		}
		if (printTimes == 0) {
			System.out.println("ERROR:  The chapter and verse does not exist, start again.");
			x = 1;
		}
		input.close();
		inputFile.reset();
	} catch (Exception e) {
		
		System.out.println("Couldn't read the psalms Error: " + e);
	}
	}
}
