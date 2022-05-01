package Assignment_10;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class WordListMain {
	/**
	 * 
	 * @param args String[]
	 */
	static String getVerse(String inLine) {
		String[] ver = inLine.split("\t");
		return ver[1];
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		WordArrayList wl = new WordArrayList();
		WordLinkedList wl2 = new WordLinkedList();
		WordHashMap wl3 = new WordHashMap();
		System.out.println("Please input the file you want to read along with the list format and minimum word occurance time.");
		String Input = input.nextLine();
		String [] Answer = Input.split(" ");
		
		try {
			// Open the required text file for sequential read
			Scanner inputFile = new Scanner (new File(Answer[0]));
			// Check for EOF, read the next line, and display it
			while (inputFile.hasNextLine()) {
				String inLine, verse;
				String[] verseParsed;
				
				inLine = inputFile.nextLine();
				verse = getVerse(inLine);
				verseParsed = verse.split("[ :;,.'!?()-]+");
				for (String s: verseParsed) {
					switch (Answer[1]) {
					case "A" :
						wl.addWord(s.toLowerCase());
						break;
					case "L":
						wl2.addWord(s.toLowerCase());
						break;
					case "H":
						wl3.addWord(s.toLowerCase());
						break;
					}
				}
				
				
		}
			inputFile.close();
			switch (Answer[1]) {
			case "A" :
				wl.printWordList(Integer.parseInt(Answer[2]));
				break;
			case "L":
				wl2.printWordList(Integer.parseInt(Answer[2]));
				break;
			case "H":
				wl3.printWordList(Integer.parseInt(Answer[2]));
				break;
			}
			
		}// END try
		catch (Exception e) {
			// All Exceptions come here for graceful termination
			System.out.println("PsalmsReaderMain Error: " + e);
		}
		
		System.out.println("\n\n\n\n\n\n\n");
		wl.addWord("Myatt");
		wl.addWord("Myatt");
		wl.addWord("Timothy");
		wl.addWord("Esquire");
		wl.addWord("Myatt");
		wl.addWord("Myatt");
		wl.addWord("Timothy");

		System.out.println("find: " + wl.findWord("Timothy"));
		System.out.println("find: " + wl.findWord("Myatt"));
		System.out.println("find: " + wl.findWord("HelpMeICan"));
		System.out.println("exists: " + wl.existsWord("Timothy"));
		System.out.println("exists: " + wl.existsWord("Myatt"));
		System.out.println("exists: " + wl.existsWord("HelpMeICan"));
		
	}
}
