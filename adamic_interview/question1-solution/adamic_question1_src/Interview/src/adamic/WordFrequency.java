package adamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordFrequency {
	
	/**
	 * @author Evan Adamic
	 * adamic.9@buckeyemail.osu.edu
	 * 
	 * Word Frequency class used to count, sort, and print the frequency of words in the 
	 * given Array of Strings
	 */

	private static final String tokenDelimiter = "\t\n\" .,!?-";
	private TreeMap<String, Integer> wordFrequencies = null;
	private ArrayList<Word> sortedFrequencies = null;
	
	public WordFrequency() {
		wordFrequencies = new TreeMap<String, Integer>();
		sortedFrequencies = new ArrayList<Word>();
	}
	
	/**
	 * Map words read in the array of strings to the number of times that word
	 * has been seen in a TreeMap
	 * @param fileData
	 */
	public void countWords(String fileData) {
		StringTokenizer strtok = new StringTokenizer(fileData);
		
		while (strtok.hasMoreTokens()) {
			String token = strtok.nextToken(tokenDelimiter).toLowerCase();
			if (wordFrequencies.containsKey(token)) {
				Integer count = wordFrequencies.get(token);
				wordFrequencies.put(token, count+1);
			}
			else {
				wordFrequencies.put(token, 1);
			}
		}
	}
	
	/**
	 * Sort the Word map entries by value in an array of Word objects
	 */
	public void sortByFrequency() {
		for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
			sortedFrequencies.add(new Word(entry.getValue(), entry.getKey()));
		}
		Collections.sort(sortedFrequencies);
	}
	
	/**
	 * Print each word key along with its count value to the console
	 */
	public void print() {
		for (Word word : sortedFrequencies) {
			System.out.println(word);
		}
	}
	
	/**
	 * Getters for private fields
	 * Used for testing
	 * @return
	 */
	public TreeMap<String, Integer> getWordFrequencies() {
		return this.wordFrequencies;
	}
	public ArrayList<Word> getSortedFrequencies() {
		return this.sortedFrequencies;
	}

}
