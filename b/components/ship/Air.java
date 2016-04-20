package b.components.ship;

import java.awt.Color;
import java.awt.Graphics;
import b.components.Ship;
import b.main.Root;

public class Air implements Ship {
	private int x;
	private int y;
	private boolean isalive = true;
	private int health = 5;
	private int length = 5;
	private boolean partoY = true;
	private boolean notIt = false;

	public Air(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void draw(Graphics g) {
		if(notIt) {
			Color old = g.getColor();
			g.setColor(Color.yellow);
			if (partoY) {
				g.fillRect(x * Root.board.square, y * Root.board.square, Root.board.square, length * Root.board.square);
			} else {
				g.fillRect(x * Root.board.square, y * Root.board.square, Root.board.square * length, Root.board.square);
			}
			g.setColor(old);
		}
		if (partoY) {
			g.fillOval(x * Root.board.square, y * Root.board.square, Root.board.square, length * Root.board.square);
		} else {
			g.fillOval(x * Root.board.square, y * Root.board.square, Root.board.square * length, Root.board.square);
		}
	}
	
	@Override
	public boolean isAlive() {
		return isalive;
	}

	@Override
	public void kill() {
		isalive = false;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public void decrementHealth() {
		health--;
		if(health <= 0) kill();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean isllToY() {
		return partoY;
	}

	@Override
	public void setllToY(boolean p) {
		partoY = p;
	}

	@Override
	public void toggledSelected() {
		notIt = !notIt;
	}

}
