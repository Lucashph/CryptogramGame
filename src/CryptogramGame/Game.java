package CryptogramGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
	private static JFrame f1, f2;
	private static JPanel p1;
	private static JPanel p2;
	private static JLabel lab1;
	private static JButton b1, b2;
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 320;
	public static final int SCALE = 2;
	public static final String TITLE = "Cryptogram Race";
	
	private boolean running = false;
	private Thread t;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private synchronized void start() {
		
		if (running) return;
		running = true;
		t = new Thread(this);
		t.start();
	}
	
	private synchronized void stop() {
		
		if (!running) return;
		running = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run() {
		
		long lastTime = System.nanoTime();
		final double noOfTicks = 60.0;
		double ns = 1000000000 / noOfTicks;
		double delta = 0.0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
//			render();
			frames++;
		}
		stop();
	}
	
	private void tick() {
		
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		f1 = new JFrame("Cryptogram Race");
		f1.setVisible(true);
		f1.setSize(900, 600);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1 = new JPanel(new GridBagLayout());
		p1.setBackground(Color.LIGHT_GRAY);
		
		lab1 = new JLabel("Cryptogram Race");
		lab1.setFont(new Font("Courier New", Font.ITALIC, 64));
		lab1.setForeground(Color.WHITE);

		b1 = new JButton("Start Game");
		b1.setFont(new Font("Courier New", Font.ITALIC, 32));
		b1.setForeground(Color.GRAY);
		
		b2 = new JButton("Quit");
		b2.setFont(new Font("Courier New", Font.ITALIC, 32));
		b2.setForeground(Color.GRAY);
		
		ActionListener action  = new ActionListener()
        {
			//checking
            public void actionPerformed(ActionEvent a)
            {
                JButton button = (JButton) a.getSource();
                if (button == b1)
                {
                    f2 = new JFrame("Cryptogram Race Game");
                    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
                    f2.setLocationByPlatform(true);

                    p2 = new JPanel();
                    p2.setBackground(Color.GRAY);

                    p2.add(b2);
                    
                    f2.add(p2);
                    
                    f2.setSize(900, 600);
                    f2.setVisible(true);
                    f1.setVisible(false);
                    f1.dispose();
                }
                else if (button == b2)
                {
                    f1.setVisible(true);
                    f2.setVisible(false);
                    f2.dispose();
                }
            }
        };

        b1.addActionListener(action);
        b2.addActionListener(action);

		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(50,10,10,10);
		c.gridx = 0;
		c.gridy = 1;
		p1.add(lab1,c);
		c.gridx = 0;
		c.gridy = 2;
		p1.add(b1,c);

		f1.add(p1);
		
		game.start();
		
	}
}
