package CryptogramGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuoteList extends Cryptogram {

	private ArrayList<String> quotes;
	
	public QuoteList() throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("quotes.txt"));
		ArrayList<Cryptogram> words = new ArrayList<Cryptogram>();
		while (in.hasNext()) {
			words.add(new Cryptogram(in.nextLine()));
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
