package Test;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -7285731868068618630L;

	public Window(int width, int height, String title, Game game) {
		JFrame jf = new JFrame(title);
		
		jf.setPreferredSize(new Dimension(width, height));
		jf.setMaximumSize(new Dimension(width, height));
		jf.setMinimumSize(new Dimension(width, height));
	
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.add(game);
		jf.setVisible(true);
		game.start();
	}
}
