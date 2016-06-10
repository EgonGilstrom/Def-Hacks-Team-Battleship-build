package b.components.ship;

import java.awt.Color;
import java.awt.Graphics;

import b.components.Ship;
import b.main.Root;
public class Cruiser implements Ship {
	private int length = 3;
	private int health = length;
	private boolean isAlive = true;
	private int x, y;
	private boolean partoY = true;
	private boolean notIt;

	public Cruiser(int x, int y) {
		this.x=x;
		this.y=y;
		}
			public boolean isAlive()
			{
				return isAlive;
			}
			public void kill()
			{
				isAlive = false;
			}
			
			public int getLength()
			{
				return length;
			}
			
			public int getHealth()
			{
				return health;
			}
			public void decrementHealth()
			{
			health--;	if(health <= 0) kill();
			}
			public int getX()
			{
				return x;
			}
			public int getY()
			{
				return y;
			}
			public void setX(int x)
			{
				this.x = x;
			}
			public void setY(int y)
			{
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
			public boolean isllToY() {
				return partoY;
			}

			@Override
			public void setllToY(boolean p) {
				partoY = p;
			}

			public void toggledSelected() {
				notIt = !notIt;
				
			}

}
