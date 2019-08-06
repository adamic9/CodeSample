package adamic;

public class Word implements Comparable<Word> {
	
	/**
	 * @author Evan Adamic
	 * adamic.9@buckeyemail.osu.edu
	 * 
	 * Word class used to compare entries from the map 
	 * by value
	 */
	
	private int count;
	private String word;
	
	public Word(int count, String word) {
		this.count = count;
		this.word = word;
	}
	
	public int compareTo(Word other) {
		return new Integer(other.count).compareTo(this.count);
	}
	
	public String toString() {
		return this.word + ": " + this.count;
	}
	
	/**
	 * Getters for private fields
	 * Used for testing
	 * @return
	 */
	public int getCount() {
		return this.count;
	}
	public String getWord() {
		return this.word;
	}
}
