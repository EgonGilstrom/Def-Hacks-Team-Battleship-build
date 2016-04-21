package b.main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame implements MouseListener, KeyListener {
	
	public int mx = -1;//Mouse event x coordinate
	public int my = -1;//Mouse event y coordinate
	public boolean lClick;//Was the mosue event a leftclick?

	public Window() {
		super("Battle Ship");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(720, 720);
		addMouseListener(this);
		addKeyListener(this);
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

	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_0) Root.keys[0] = true;
		else if(e.getKeyCode() == e.VK_1) Root.keys[1] = true;
		else if(e.getKeyCode() == e.VK_2) Root.keys[2] = true;
		else if(e.getKeyCode() == e.VK_3) Root.keys[3] = true;
		else if(e.getKeyCode() == e.VK_4) Root.keys[4] = true;
		else if(e.getKeyCode() == e.VK_5) Root.keys[5] = true;
		else if(e.getKeyCode() == e.VK_6) Root.keys[6] = true;
		else if(e.getKeyCode() == e.VK_7) Root.keys[7] = true;
		else if(e.getKeyCode() == e.VK_8) Root.keys[8] = true;
		else if(e.getKeyCode() == e.VK_9) Root.keys[9] = true;
		else if(e.getKeyCode() == e.VK_A) Root.keys[10] = true;
		else if(e.getKeyCode() == e.VK_B) Root.keys[11] = true;
		else if(e.getKeyCode() == e.VK_C) Root.keys[12] = true;
		else if(e.getKeyCode() == e.VK_D) Root.keys[13] = true;
		else if(e.getKeyCode() == e.VK_E) Root.keys[14] = true;
		else if(e.getKeyCode() == e.VK_F) Root.keys[15] = true;
		else if(e.getKeyCode() == e.VK_LEFT) Root.keys[16] = true;
		else if(e.getKeyCode() == e.VK_RIGHT) Root.keys[17] = true;
		else if(e.getKeyCode() == e.VK_ENTER) Root.keys[18] = true;
	}

	@SuppressWarnings("static-access")
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == e.VK_0) Root.keys[0] = false;
		else if(e.getKeyCode() == e.VK_1) Root.keys[1] = false;
		else if(e.getKeyCode() == e.VK_2) Root.keys[2] = false;
		else if(e.getKeyCode() == e.VK_3) Root.keys[3] = false;
		else if(e.getKeyCode() == e.VK_4) Root.keys[4] = false;
		else if(e.getKeyCode() == e.VK_5) Root.keys[5] = false;
		else if(e.getKeyCode() == e.VK_6) Root.keys[6] = false;
		else if(e.getKeyCode() == e.VK_7) Root.keys[7] = false;
		else if(e.getKeyCode() == e.VK_8) Root.keys[8] = false;
		else if(e.getKeyCode() == e.VK_9) Root.keys[9] = false;
		else if(e.getKeyCode() == e.VK_A) Root.keys[10] = false;
		else if(e.getKeyCode() == e.VK_B) Root.keys[11] = false;
		else if(e.getKeyCode() == e.VK_C) Root.keys[12] = false;
		else if(e.getKeyCode() == e.VK_D) Root.keys[13] = false;
		else if(e.getKeyCode() == e.VK_E) Root.keys[14] = false;
		else if(e.getKeyCode() == e.VK_F) Root.keys[15] = false;
		else if(e.getKeyCode() == e.VK_LEFT) Root.keys[16] = false;
		else if(e.getKeyCode() == e.VK_RIGHT) Root.keys[17] = false;
		else if(e.getKeyCode() == e.VK_ENTER) Root.keys[18] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
