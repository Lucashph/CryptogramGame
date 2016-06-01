package CryptogramGame;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;

// Used to test for errors

public class test {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		
		JFrame jf = new JFrame("TEST");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(640 * 2, 320 * 2);
		QuoteList q = new QuoteList();
		Cryptogram c = q.getRandomQuote();
		jf.getContentPane().add(c);
		jf.setVisible(true);
		c.start();
	}
}
