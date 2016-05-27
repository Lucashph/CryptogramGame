package CryptogramGame;

import java.util.ArrayList;
import java.util.Random;

public class Cryptogram {

	private String quotePerson, quote;
	private ArrayList<Character> encodedQuote;
	
	private static Random randGen = new Random(System.currentTimeMillis());

	public Cryptogram(String quotePerson) {

		this.quotePerson = quotePerson;

		String[] parts = quotePerson.split("\"");
		quote = "";
		if (parts.length > 1) {
			quote = parts[1];
		}

		ArrayList<Character> letters = new ArrayList<Character>();
		for (char c = 65; c <= 90; c++) {
			letters.add(c);
		}
		
		// do a Fischer-Yates shuffle
		for (int i = letters.size() - 1; i > 0; i--) {
			int j = randGen.nextInt(i); // so 0 <= j < i
			Character c = letters.get(i);
			letters.set(i, letters.get(j));
			letters.set(j, c);
		}
		
		// now `letters` is certifiably 100% randomly shuffled
		encodedQuote = new ArrayList<Character>();
		char[] chars = quote.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = Character.toUpperCase(chars[i]);
			if (65 <= c && c <= 90) {
				encodedQuote.add(letters.get(c - 65));
			} else {
				encodedQuote.add(c);
			}
		}
	}

	public String getEncodedQuoteAsString() {
		
		char[] chars = new char[encodedQuote.size()];
		int i = 0;
		for (char c : encodedQuote) {
			chars[i] = c;
			i++;
		}
		return new String(chars);
	}
	
	public String hint() {
		
		int randPosition;
		do {
			randPosition = randGen.nextInt(encodedQuote.size() - 1);
		} while (encodedQuote.get(randPosition).equals(' '));
		return "(\"" + encodedQuote.get(randPosition) + "\" equals \"" + quotePerson.substring(randPosition + 1, randPosition + 2).toUpperCase() + "\".)";
	}
	
	public String getQuotePerson() {

		return this.quotePerson;
	}

	public String getQuote() {

		return quote;
	}

	public ArrayList<Character> getEncodedQuote() {

		return encodedQuote;
	}
}
