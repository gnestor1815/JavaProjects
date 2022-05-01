package Assignment_10;

import java.util.LinkedList;
import java.util.ListIterator;


class WordCountNode {
	String word;
	int count;
	
	/**
	 * WordCountNode constructor
	 * @param inWord
	 */
	public WordCountNode(String inWord) {
		word = inWord;
		count = 1;
	}	
	
	/**
	 * @return the object word datum
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * @return the object count datum
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the object count auto-incremented
	 */
	public int incrementCount() {
		count++;
		return count;
	}
}

public class WordLinkedList extends WordList {
	static LinkedList<WordCountNode> words = new LinkedList<WordCountNode>();
	
	public WordLinkedList() {
		super();
	}
	
	public int findWord(String inWord) {
		boolean foundWord = false;
		int i = 0;
		for (i = 0; i < words.size(); i++) {
			WordCountNode n = words.get(i);
			if (inWord.compareTo(n.getWord()) == 0) {
				foundWord = true;
				
				break;
			}
		}
		
		if (foundWord) {
			WordCountNode n = words.get(i);
			return n.getCount();
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
 		boolean foundWord = false;
		int i = 0;
		for (i = 0; i < words.size(); i++) {
			WordCountNode n = words.get(i);
			if (inWord.compareTo(n.getWord()) == 0) {
				foundWord = true;
				break;
			}
		}
		
		if (foundWord) {
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
 	boolean foundWord = false;
		
		for (int i = 0; i < words.size(); i++) {
			WordCountNode n = words.get(i);
			if (inWord.compareTo(n.getWord()) == 0) {
				foundWord = true;
				n.incrementCount();
				super.incTotalAllWords();
				break;
			}
		}
		
		if (!foundWord) {
			words.add(new WordCountNode(inWord));
			super.incTotalAllWords();
			super.incNumUniqueWords();
	}
		
		return words.size();
 	}
 	
 	/**
 	 * Public abstract method incWord
 	 * @param inWord String
 	 * @return 0 if inWord not found, new inWord count if found
 	 */
 	public int incWord(String inWord) {
 		boolean foundWord = false;
		int index = 0;

		for (index = 0; index < words.size(); index++) {
			WordCountNode n = words.get(index);
			if (inWord.compareTo(n.getWord()) == 0) {
				foundWord = true;
				break;
			}
		}
		if (foundWord) {
			WordCountNode n = words.get(index);
			super.incTotalAllWords();
			n.incrementCount();
			return n.getCount();
		} else {
			return 0;
		}
 	}
 	
 	/**
 	 * Public abstract method printWordList
 	 * @param inMinimum int
 	 */
 	public void printWordList(int inMinimum) {
 		System.out.println(super.toString());
 		for (int i = 0; i < words.size(); i++) {
			WordCountNode n = words.get(i);
 			if (n.getCount() >= inMinimum) {
				System.out.println(n.getWord() + 
						":"+ n.getCount());
			}
 		}
 	}
 	
 	public String toString() {
		return super.toString();
	}
}

