package CryptogramGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuoteList {

	private ArrayList<String> quotes;
	
	public QuoteList() throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("quotes.txt"));
		this.quotes = new ArrayList<String>();
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			this.quotes.add(line);
		}
	}
	
	public String getRandomQuote() {
		
		int rand = (int) (Math.random() * this.quotes.size());
		return this.quotes.get(rand);
	}
	
	public ArrayList<String> getQuotes() {
		
		return this.quotes;
	}
}
