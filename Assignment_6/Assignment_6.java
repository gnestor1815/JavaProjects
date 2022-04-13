package Assignment_6;

import java.io.*;
import java.util.*;

/**
 * PsalmsReaderMain class - Template for Assignment-5
 * @author TMyatt
 *
 */
public class Assignment_6 {
	static ArrayList<String> words = new ArrayList<String>();
	static ArrayList<Integer> count = new ArrayList<Integer>();
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
			if (inWord.compareTo(words.get(i)) == 0) {
				foundWord = true;
				count.set(i, count.get(i)+1);
				break;
			}
		}
		// If word not found in the loop above, add it to list bottom
		if (!foundWord) {
			moveStringCount++;
			words.add( String.valueOf(inWord)); 
			count.add(1);
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
			if (inWord.compareTo(words.get(i)) == 0) {
				foundWord = true;
				count.set(i, count.get(i)+1);
				break;
			}
		}
		// If word not found in the loop above, add it to sorted list
		if (!foundWord) {
			if(lastIndex == 0) {
				words.add(String.valueOf(inWord)); 
				count.add(1);
			} else if ((words.get(lastIndex - 1).compareTo(inWord) < 0)) {
				
			newWord = lastIndex;
			} else {
				for (int j = 0; j < lastIndex; j++) {
					if ((words.get(j).compareTo(inWord) < 0) && 
							(words.get(j + 1).compareTo(inWord) > 0)) {
						
						newWord = j + 1;
						break;
					}
				}
				for (int n = lastIndex; n > newWord; n--) {
					moveStringCount++;
					if (n == lastIndex) {
						words.add(words.get(n-1));
						count.add(count.get(n-1));
					} else {
					words.set(n, words.get(n-1));
					count.set(n, count.get(n-1));
					}
				}
			}
			if (lastIndex!=0) {
				moveStringCount++;
				if (newWord == lastIndex) {
				words.add(String.valueOf(inWord)); 
				count.add(1);
				} else {
					words.set(newWord, String.valueOf(inWord)); 
					count.set(newWord, 1);
				}
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
			if (count.get(i) >= inMinimum) {
				System.out.println(words.get(i) + ":" + count.get(i));
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
					new Scanner (new File("bible-psalms.txt"));
			// Check for EOF, read the next line, and display it
			while (inputFile.hasNextLine()) {
				String inLine, verse;
				String[] verseParsed;
				
				inLine = inputFile.nextLine();
				verse = getVerse(inLine);
				verseParsed = verse.split("[ :;,.'!?()-]+");

				for (String s: verseParsed) {
					addWordToList(s.toLowerCase());
					//addWordToSortedList(s.toLowerCase());
				}
			}
			// Close the required file when EOF is reached
			inputFile.close();
			printWordList(1000);
			
		} // END try
		catch (Exception e) {
			// All Exceptions come here for graceful termination
			System.out.println("PsalmsReaderMain Error: " + e);
		} // END catch
	} // END main
} // END class


