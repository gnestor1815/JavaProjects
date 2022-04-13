package Assignment_5;

import java.io.*;
import java.util.*;

/**
 * PsalmsReaderMain class - Template for Assignment-5
 * @author TMyatt
 *
 */
public class Assignment5 {
	static String words[] = new String[1000000];
	static int count[] = new int[1000000];
	static int lastIndex = 0;
	static long compareStringCount = 0;
	static long moveStringCount = 0;
	
	/**
	 * addWordToList - add word to list or increment counter
	 * @param inWord - the word to add to the list
	 * @return number of words in the list
	 */
	static int addWordToList(String inWord) {
		boolean foundWord = false;
		
		// Search for word, set boolean and increment count if found
		for (int i = 0; i < lastIndex; i++) {
			compareStringCount++;
			if (inWord.compareTo(words[i]) == 0) {
				foundWord = true;
				count[i]++;
				break;
			}
		}
		// If word not found in the loop above, add it to list bottom
		if (!foundWord) {
			moveStringCount++;
			words[lastIndex] = String.valueOf(inWord);
			count[lastIndex] = 1;
			lastIndex += 1;
		}
		return lastIndex;
	}
	
	/**
	 * addWordToListSorted - add word to sorted list or increment counter
	 * @param inWord - the word to add to the list
	 * @return number of words in the list
	 */
	
	static int addWordToSortedList(String inWord) {
		boolean foundWord = false;
		int newWord = 0;
		for (int i = 0; i < lastIndex; i++) {
			compareStringCount++;
			if (inWord.compareTo(words[i]) == 0) {
				foundWord = true;
				count[i]++;
				break;
			}
		}
		// If word not found in the loop above, add it to sorted list
		if (!foundWord) {
			if(lastIndex == 0) {
				words[lastIndex] = String.valueOf(inWord);
				count[lastIndex] = 1;
			} else if ((words[lastIndex - 1].compareTo(inWord) < 0)) {
				
			newWord = lastIndex;
			} else {
				for (int j = 0; j < lastIndex; j++) {
					if ((words[j].compareTo(inWord) < 0) && 
							(words[j + 1].compareTo(inWord) > 0)) {
						
						newWord = j + 1;
						break;
					}
				}
				for (int n = lastIndex; n > newWord; n--) {
					moveStringCount++;
					words[n] = words[n-1];
					count[n] = count[n-1];
				}
			}
			if (lastIndex!=0) {
				moveStringCount++;
				words[newWord] = String.valueOf(inWord);
				count[newWord] = 1;
			}
			lastIndex += 1;
		}

		return lastIndex;
	}
	
	/**
	 * printWordList - dump the list if count > inMinimum
	 */
	static void printWordList(int inMinimum) {
		System.out.println("Total words: " + lastIndex);
		System.out.println("Compare count: " + compareStringCount);
		System.out.println("Move count: " + moveStringCount);
		for (int i = 0; i < lastIndex; i++) {
			if (count[i] >= inMinimum) {
				System.out.println(words[i] + ":" + count[i]);
			}
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
	 * PsalmsReaderMain main() - Template for Assignment-5
	 * @param args
	 */
	public static void main(String[] args) {
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

				for (String s: verseParsed) {
					//addWordToList(s.toLowerCase());
					addWordToSortedList(s.toLowerCase());
				}
			}
			// Close the required file when EOF is reached
			inputFile.close();
			printWordList(10000);
			
		} // END try
		catch (Exception e) {
			// All Exceptions come here for graceful termination
			System.out.println("PsalmsReaderMain Error: " + e);
		} // END catch
	} // END main
} // END class


