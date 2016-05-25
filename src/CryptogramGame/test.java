package CryptogramGame;

import java.io.FileNotFoundException;
import java.util.ArrayList;

// Used to test for errors

public class test {

	public static void main(String[] args) throws FileNotFoundException {
		
		QuoteList q = new QuoteList();
		
		Cryptogram c = q.getRandomQuote();
		
		ArrayList<Character> encoded = c.getEncodedQuote();
		
		String qu = c.getQuote();
		
		System.out.println(c.getQuoteArray().size());
	}
}
