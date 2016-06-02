package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuoteList {

	private ArrayList<Cryptogram> quotes;
	Game game;
	
	public QuoteList() throws FileNotFoundException {
		
		Scanner in = new Scanner(new File("quotes.txt"));
		quotes = new ArrayList<Cryptogram>();
		while (in.hasNext()) {
			quotes.add(new Cryptogram(ID.Cryptogram, 1, in.nextLine()));
		}
	}
	
	public Cryptogram getRandomQuote() {
		
		int rand = (int) (Math.random() * quotes.size());
		return quotes.get(rand);
	}
	
	public ArrayList<Cryptogram> getQuotes() {
		
		return quotes;
	}
}
