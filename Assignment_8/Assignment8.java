package Assignment_8;

import java.io.*;
import java.util.*;

/**
 * PsalmsReaderMain class - Template for Assignment-8
 * @author TMyatt
 *
 */
public class Assignment8 {
	static HashMap<String, Integer>wordsHash =
			new HashMap<String, Integer>();
	static TreeMap<String, Integer> wordsTree =
			new TreeMap<String, Integer>();
	
	/**
	 * addWordToHashMap - add word to list or increment counter
	 * @param inWord - the word to add to the list
	 * @return number of words in the list
	 */
	static int addWordToHashMap(String inWord) {
		if (wordsHash.containsKey(inWord)) {
			wordsHash.put(inWord, wordsHash.get(inWord) + 1);
		} else {
			wordsHash.put(inWord, 1);
		}
		return wordsHash.size();
	}
	
	/**
	 * addWordToTreeMap - add word to sorted list or increment counter
	 * @param inWord - the word to add to the list
	 * @return number of words in the list
	 */
	static int addWordToTreeMap(String inWord) {
		if (wordsTree.containsKey(inWord)) {
			wordsTree.put(inWord, wordsTree.get(inWord) + 1);
		} else {
			wordsTree.put(inWord, 1);
		}
		return wordsTree.size();
	}
	
	/**
	 * printWordList - dump the list if count > inMinimum
	 */
	static void printWordList(int inMinimum) {
		if (wordsHash.size() > 0) {
			System.out.println("Total words: " + wordsHash.size());
			wordsHash.entrySet().forEach(wordsHash -> {
				if (wordsHash.getValue() >= inMinimum) {
			    System.out.println(wordsHash.getKey() + " " + wordsHash.getValue());
				}
			});
		}
		if (wordsTree.size() > 0) {
			System.out.println("Total words: " + wordsTree.size());
			wordsTree.entrySet().forEach(wordsTree -> {
				if (wordsTree.getValue() >= inMinimum) {
			    System.out.println(wordsTree.getKey() + " " + wordsTree.getValue());
				}
			});
		}
	}

	/**
	 * getVerse - Parse and return only the Psalms verse
	 * @param inLine - the line to parse on tab delimiter
	 * @return right half of tab delimited string
	 */
	static String getVerse(String inLine) {
		String[] ver = inLine.split("\t");
		return ver[1];
	}

	/**
	 * PsalmsReaderMain main() - Template for Assignment-8
	 * @param args
	 */
	public static void main(String[] args) {
		long microTime, microTimeSum = 0;
		try {
			// Open the required text file for sequential read
			Scanner inputFile =
					new Scanner (new File("bible-complete10.txt"));
			// Check for EOF, read the next line, and display it
			while (inputFile.hasNextLine()) {
				String inLine, verse;
				String[] verseParsed;
				
				inLine = inputFile.nextLine();
				verse = getVerse(inLine);
				verseParsed = verse.split("[ :;,.'!?()-]+");
				// We're going to do a microsecond execution calc
		        microTime = System.nanoTime()/1000;
				for (String s: verseParsed) {
					//addWordToHashMap(s.toLowerCase());
					addWordToTreeMap(s.toLowerCase());
				}
				microTimeSum += (System.nanoTime()/1000 - microTime);
			}		
			// Close the required file when EOF is reached
			inputFile.close();
			printWordList(10000);
	        System.out.println("Elapsed Time: " + microTimeSum);
		} // END try
		catch (Exception e) {
			// All Exceptions come here for graceful termination
			System.out.println("PsalmsReaderMain Error: " + e);
		} // END catch		
	} // END main
} // END class
