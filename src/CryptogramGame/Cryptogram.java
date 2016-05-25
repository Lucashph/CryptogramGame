package CryptogramGame;

import java.util.ArrayList;

public class Cryptogram {

	private String quotePerson, quote;
	private ArrayList<Character> quoteArray, encodedQuote;
	
	public Cryptogram(String quotePerson) {
		
		this.quotePerson = quotePerson;
		
		this.quote = "";
		for (int i = 1; i < quotePerson.length(); i++) {
			for (int j = i; !quotePerson.substring(j, j + 1).equals("\""); j++) {
				this.quote += quotePerson.substring(j, j + 1);
			}
			return;
		}
		//////// I think the problem is in here ////////
		this.quoteArray = new ArrayList<Character>();
		for (int i = 0; i < this.quote.length(); i++) {
			this.quoteArray.add(this.quote.charAt(i));
		}
		///////////////////////////////////////////////
		this.encodedQuote = new ArrayList<Character>();
		
		ArrayList<Character> letters = new ArrayList<Character>();
		for (char c = 65; c <= 90; c++) {
			letters.add(c);
		}
		
		for (int i = 0; i < this.quoteArray.size(); i++) {
			ArrayList<Character> done = new ArrayList<Character>();
			int availableLetters = 26;
			char rand = letters.get((char) (Math.random() * availableLetters));
			if (((this.quoteArray.get(i) >= 65 && this.quoteArray.get(i) <= 90) || 
				(this.quoteArray.get(i) >= 97 && this.quoteArray.get(i) <= 122)) && 
				done.indexOf(this.quoteArray.get(i)) == -1) {
				for (int j = 0; j < quoteArray.size(); j++) {
					if (quoteArray.get(i) == quoteArray.get(j)) {
						this.encodedQuote.add(j, rand);
					}
				}
				letters.remove(rand);
				done.add(quoteArray.get(i));
				availableLetters--;
			} else {
				this.encodedQuote.add(i, this.quoteArray.get(i));
			}
		}
	}
	
	public String getQuotePerson() {
		
		return this.quotePerson;
	}
	
	public String getQuote() {
		
		return this.quote;
	}
	
	public ArrayList<Character> getQuoteArray() {
		
		return this.quoteArray;
	}
	
	public ArrayList<Character> getEncodedQuote() {
		
		return this.encodedQuote;
	}
}
