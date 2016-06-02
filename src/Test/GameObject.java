package Test;

import java.awt.Graphics;

public abstract class GameObject {

	protected int velY;
	protected ID id;
	
	public GameObject(ID id, int velY) {
		this.id = id;
		this.velY = velY;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setId(ID id) {
		this.id = id;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public ID getId() {
		return id;
	}
	
	public int getVelY() {
		return velY;
	}
}
