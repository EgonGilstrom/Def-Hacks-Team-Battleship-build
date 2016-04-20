package b.main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame implements MouseListener {
	
	public int mx = -1;//Mouse event x coordinate
	public int my = -1;//Mouse event y coordinate
	public boolean lClick;//Was the mosue event a leftclick?

	public Window() {
		super("Battle Ship");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(720, 720);
		addMouseListener(this);
		getContentPane().setBackground(new Color(74, 204, 247));
		setVisible(true);
	}

	@SuppressWarnings("static-access")
	@Override
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		if(e.getButton() == e.BUTTON1) lClick = true;
		else if(e.getButton() == e.BUTTON3) lClick = false;
		else {
			mx = -1;
			my = -1;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
}
