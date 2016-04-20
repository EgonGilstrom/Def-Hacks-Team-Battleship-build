package b.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class WinComponent extends JComponent {
	
	public ArrayList<drawable> elems;
	
	public WinComponent(ArrayList<drawable> elms) {
		super();
		elems = elms;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		g.drawString("Player: " + ((Root.player1Turn) ? "1" : "2"), (int) ((Root.win.getWidth() * 12/16) * 1.125), 10);
		for(drawable d : elems) d.draw(g);
	}
	
}
