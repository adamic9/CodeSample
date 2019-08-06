package test;

import static org.junit.Assert.*;

import org.junit.Test;

import adamic.Word;

public class WordTest {

	@Test
	public void testCompareTo() {
		Word word1 = new Word(1, "word1");
		Word word2 = new Word(5, "word2");
		
		assertEquals(1, word1.compareTo(word2));
	}

}
