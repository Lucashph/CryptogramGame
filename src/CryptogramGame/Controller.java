package CryptogramGame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Controller {

	private LinkedList<Cryptogram> c = new LinkedList<Cryptogram>();
	
	Cryptogram tempCryptogram;
	
	public void tick() {
		
		for (int i = 0; i < c.size(); i++) {
			tempCryptogram = c.get(i);
			tempCryptogram.tick();
		}
	}
	
	public void render(Graphics g) {
		
		for (int i = 0; i < c.size(); i++) {
			tempCryptogram = c.get(i);
			tempCryptogram.render(g);
		}
	}
	
	public void addCryptogram(Cryptogram block) {
		
		c.add(block);
	}
	
	public void removeCryptogram(Cryptogram block) {
		
		c.remove(block);
	}
}
