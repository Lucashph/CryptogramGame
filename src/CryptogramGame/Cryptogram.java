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
		this.quote = "";
		if (parts.length > 1) {
			this.quote = parts[1];
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

		this.encodedQuote = new ArrayList<Character>();
		char[] chars = this.quote.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = Character.toUpperCase(chars[i]);
			if (65 <= c && c <= 90) {
				this.encodedQuote.add(letters.get(c - 65));
			} else {
				this.encodedQuote.add(c);
			}
		}
	}

	public String getQuotePerson() {

		return this.quotePerson;
	}

	public String getQuote() {

		return this.quote;
	}

	public ArrayList<Character> getEncodedQuote() {

		return this.encodedQuote;
	}
	
	public String getEncodedQuoteAsString() {
		char[] chars = new char[this.encodedQuote.size()];
		int i = 0;
		for (char c : this.encodedQuote) {
			chars[i] = c;
			i++;
		}
		return new String(chars);
	}
}
