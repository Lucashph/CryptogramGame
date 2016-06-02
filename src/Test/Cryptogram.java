package Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

public class Cryptogram extends GameObject {

	private int x, y;
	private boolean check;
	private String quotePerson, quote, hint;
	private ArrayList<Character> encodedQuote;
	
	private static Random randGen = new Random(System.currentTimeMillis());

	public Cryptogram(ID id, int velY, String quotePerson) {
			
		super(id, velY);
		
		x = 0;
		y = 0;
		
		check = true;
		
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
		
		int randPosition;
		do {
			randPosition = randGen.nextInt(encodedQuote.size() - 1);
		} while (encodedQuote.get(randPosition).equals(' '));
		hint = "(\"" + encodedQuote.get(randPosition) + "\" equals \"" + quotePerson.substring(randPosition + 1, randPosition + 2).toUpperCase() + "\".)";
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
	
	public String getEncodedQuoteAsString() {
		
		char[] chars = new char[encodedQuote.size()];
		int i = 0;
		for (char c : encodedQuote) {
			chars[i] = c;
			i++;
		}
		return new String(chars);
	}
	
	public String getHint() {
		
		return hint;
	}

	public void tick() {
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Courier", Font.PLAIN, 12));
		int quoteWidth = g.getFontMetrics().stringWidth(this.getEncodedQuoteAsString() + " " + this.hint);
		while (this.check) {
			this.x = (int) (Math.random() * 840);
			while (this.x + quoteWidth > 840) {
				this.x = (int) (Math.random() * 840);
			}
			this.check = false;
		}
		g.drawString(this.getEncodedQuoteAsString() + " " + this.hint, this.x, this.y);
	}
}
