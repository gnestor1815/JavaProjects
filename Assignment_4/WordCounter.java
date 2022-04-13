package Assignment_4;


import java.io.*;
import java.util.*;

public class WordCounter {
	static String words[] = new String[100000];
	static int count[] = new int[100000];
	static int lastIndex = 0;
	
	static int addWordToList(String inWord) {
		
		for (int i = 0; i <= 99999;) {
			if (i < lastIndex) {
				if (inWord.equals(words[i])) {
				count[i]++;
				break;
				}
			} else if (i == lastIndex) {
				words[i + 1] = inWord;
				lastIndex++;
				break;
			}
			i++;
			
		}
		return lastIndex;
	}
	
	static void printWordList(int inMinimum) {
		for (int i = 1; i <=99999; i++) {
			if (count[i] >= inMinimum) {
				System.out.println("Word: " + words[i]);
				System.out.println("Occurences: " + count[i]);
			}
		}
	}

	static String getVerse(String inLine) {
		String ver = "";
		String[] ver2 = inLine.split("	");
		ver = ver2[1];
		return ver;
	}

	public static void main(String[] args) {
		try {
			// Open the required text file for sequential read
			Scanner inputFile =
					new Scanner (new File("bible-psalms.txt"));
			// Check for EOF, read the next line, and display it
			while (inputFile.hasNextLine()) {
				String inLine, verse;
				String[] verseParsed;
				
				inLine = inputFile.nextLine();
				//verse = getVerse(inLine);
				verseParsed = inLine.split("[ :;,.'!?()-]+");
	
				for (String s: verseParsed) {
					addWordToList(s.toLowerCase());
				}
			}
			// Close the required file when EOF is reached
			inputFile.close();
			printWordList(10000);
			Scanner inputSearch = new Scanner(System.in);
			System.out.println("What word do you want to search?");
			String input = inputSearch.next();
			for (int i = 0; i <= 99999; i++) {
				if (input.equals(words[i])) {
					System.out.println("Word: " + words[i]);
					System.out.println("Occurences: " + count[i]);
					break;
				} 
			}
		} 
		catch (Exception e) {
			System.out.println("PsalmsReaderMain Error: " + e);
		}
	}
}


