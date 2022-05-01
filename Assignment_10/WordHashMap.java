package Assignment_10;
import java.io.*;
import java.util.*;

/**
 * PsalmsReaderMain class - Template for Assignment-8
 * @author TMyatt
 *
 */
public class WordHashMap extends WordList{
	static HashMap<String, Integer>wordsHash =
			new HashMap<String, Integer>();
	static TreeMap<String, Integer> wordsTree =
			new TreeMap<String, Integer>();
	
	public WordHashMap() {
		super();
	}
	
public int findWord(String inWord) {
	if (wordsHash.containsKey(inWord)) {
		return wordsHash.get(inWord);
	} else {
		return 0;
	}
}
 	
 	/**
 	 * Public abstract method existsWord
 	 * @param inWord String
 	 * @return True if inWord exists in WordList
 	 */
 	public boolean existsWord(String inWord) {
 		if (wordsHash.containsKey(inWord)) {
			return true;
		} else {
			return false;
		}
	}

 	/**
 	 * Public abstract method addWord
 	 * @param inWord String
 	 * @return 1 if inWord not found, new inWord count if found
 	 */
 	public int addWord(String inWord) {
 		if (wordsHash.containsKey(inWord)) {
			wordsHash.put(inWord, wordsHash.get(inWord) + 1);
			super.incTotalAllWords();
		} else {
			wordsHash.put(inWord, 1);
			super.incNumUniqueWords();
			super.incTotalAllWords();
		}
		return wordsHash.size();
	}
 	
 	/**
 	 * Public abstract method incWord
 	 * @param inWord String
 	 * @return 0 if inWord not found, new inWord count if found
 	 */
 	public int incWord(String inWord) {
 		if (wordsHash.containsKey(inWord)) {
			wordsHash.put(inWord, wordsHash.get(inWord) + 1);
			super.incTotalAllWords();
		} else {
			return 0;
		}
		return wordsHash.size();
	}
 	
 	/**
 	 * Public abstract method printWordList
 	 * @param inMinimum int
 	 */
 	public void printWordList(int inMinimum) {
 		System.out.println(super.toString());
 		wordsHash.entrySet().forEach(wordsHash -> {
			if (wordsHash.getValue() >= inMinimum) {
		    System.out.println(wordsHash.getKey() + ": " + wordsHash.getValue());
			}
		});
	}
}
