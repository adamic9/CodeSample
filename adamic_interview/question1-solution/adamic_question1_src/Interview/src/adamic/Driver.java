package adamic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Driver {

	/**
	 * @author Evan Adamic
	 * adamic.9@buckeyemail.osu.edu
	 * 7/9/19
	 * Interview
	 * 
	 * Driver class to read and map words to their frequency in the
	 * file, sort all seen words by their frequency (descending), and
	 * display the results.
	 * 
	 * Question 1 - Generate a count of the occurrences of each word 
	 * for the text found in the file Paragraph.txt. Output a list of 
	 * words and counts in descending count order (word with highest 
	 * count listed first).
	 */
	private static String FilePath = "docs/Question1.out.txt";
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.print("Error: arg count must be 1");
		}
		if (!args[0].endsWith(".txt")) {
			System.err.print("Error: arg must be .txt file");
		}
		
		ArrayList<String> fileData = new ArrayList<String>(readFile(args[0]));
		
		WordFrequency wordFreq = new WordFrequency();
		for (int i=0; i<fileData.size(); i++){
			wordFreq.countWords(fileData.get(i));
		}
		wordFreq.sortByFrequency();
		wordFreq.print();
		
		writeFile(wordFreq.getSortedFrequencies());
	}
	
	/**
	 * Read the text file and store each line in an array of Strings
	 * @param fileName
	 * @return fileData
	 */
	private static ArrayList<String> readFile(String fileName) {
		ArrayList<String> fileData = new ArrayList<String>();
		String line = "";
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (IOException e) {
			System.out.println("Cannot find file " + fileName);
			System.exit(0);
		}
		
		try {
			while ((line = br.readLine()) != null) {
				fileData.add(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading " + fileName);
			System.exit(0);
		}
		
		return fileData;
	}

	private static void writeFile(ArrayList<Word> sortedWords) {
		ArrayList<String> lines = new ArrayList<String>();
		for (Word word : sortedWords) {
			lines.add(word.toString());
		}

		Path filePath = Paths.get(FilePath);
		try {
			Files.write(filePath, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Error writing file");
			System.exit(0);
		}
		
	}
}
