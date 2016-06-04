package b.components;

import java.awt.Graphics;

import b.main.drawable;

public class Ship implements drawable {
	
	public int x, y, length, health;
	public boolean notIt, partoY, isalive;
	
	public Ship(int X, int Y) {
		x = X;
		y = Y;
		notIt = false;
		partoY = true;
		isalive = true;
	}
	
	public boolean isAlive() {
		return isalive;
	}
	public void kill() {
		isalive = false;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getHealth() {
			return health;
	}
	public void decrementHealth() {
		health--;
	}
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public void setX(int x){ this.x = x; }
	public void setY(int y){ this.y = y; }
	
	public boolean isllToY(){ return partoY; }
	public void setllToY(boolean p){ partoY = p; }
	
	public void toggledSelected(){ notIt = !notIt; }

	@Override
	public void draw(Graphics g) {
		
	}
	
}
