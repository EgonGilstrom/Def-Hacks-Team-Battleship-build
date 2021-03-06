package b.components.ship;

import java.awt.Color;
import java.awt.Graphics;
import b.components.Ship;
import b.main.Root;

public class Air extends Ship {

	public Air(int x, int y) {
		super(x, y);
		length = 5;
		health = 5;
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

}
