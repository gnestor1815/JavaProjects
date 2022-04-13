package Assignment_2;

import java.awt.*;
import java.util.*;
import java.io.*;

public class PsalmsReader {

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("What Book of Psalms chapter?: ");
		int chaptNum = input.nextInt();
		String chaptSelect = Integer.toString(chaptNum);
		System.out.println("What Book of Psalms verse within the chapter? : ");
		int verseNum = input.nextInt();
		String verSelect = Integer.toString(verseNum);
		
		input.close();
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
			System.out.print("ERROR The chapter and verse you've selected dont exist.");
		}
		inputFile.close();
	} catch (Exception e) {
		
		System.out.println("Couldn't read the psalms Error: " + e);
	}
	
	
	
	
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
}
