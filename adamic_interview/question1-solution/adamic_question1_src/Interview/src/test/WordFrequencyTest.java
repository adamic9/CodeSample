package test;

import static org.junit.Assert.*;

import org.junit.Test;

import adamic.WordFrequency;

public class WordFrequencyTest {

	private String testString = "This is a test test String";
	
	@Test
	public void testCountWords() {
		WordFrequency testWF = new WordFrequency();
		testWF.countWords(testString);
		
		assertEquals(1, testWF.getWordFrequencies().get("this").intValue());
		assertEquals(1, testWF.getWordFrequencies().get("is").intValue());
		assertEquals(1, testWF.getWordFrequencies().get("a").intValue());
		assertEquals(2, testWF.getWordFrequencies().get("test").intValue());
		assertEquals(1, testWF.getWordFrequencies().get("string").intValue());
		
	}
	
	@Test
	public void testSortbyFrequency() {
		WordFrequency testWF = new WordFrequency();
		testWF.countWords(testString);
		testWF.sortByFrequency();
		
		// test => 2, should be first
		// the rest with count=1 are sorted lexicographically by default
		assertEquals("test", testWF.getSortedFrequencies().get(0).getWord());
		assertEquals("a", testWF.getSortedFrequencies().get(1).getWord());
		assertEquals("is", testWF.getSortedFrequencies().get(2).getWord());
		assertEquals("string", testWF.getSortedFrequencies().get(3).getWord());
		assertEquals("this", testWF.getSortedFrequencies().get(4).getWord());
	}

}
