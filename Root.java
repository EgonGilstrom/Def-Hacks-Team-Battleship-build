package b.main;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import b.components.*;

@SuppressWarnings("unused")
public class Root {
	
	private static boolean running = true;
	public static Window win;
	public static WinComponent wcp;
	public static ArrayList<drawable> drawObjs;
	public static Board board;
	public static String[] pws;
	public static boolean player1Turn;
	public static boolean pregame = true;
	public static int[] turnCounter;

	public static void main(String[] args) {
		win = new Window();
		drawObjs = new ArrayList<drawable>();
		wcp = new WinComponent(drawObjs);
		win.add(wcp);
		pws = new String[2];
		pws[0] = JOptionPane.showInputDialog("Please Enter Player1 Password:");
		pws[1] = JOptionPane.showInputDialog("Please Enter Player2 Password:");
		board = new Board();
		drawObjs.add(board);
		player1Turn = true;
		turnCounter = new int[2];
		turnCounter[0] = 0;
		turnCounter[1] = 0;
		run();
	}
	
	private static void run() {
		double delta = 0;
		long oldTime = System.nanoTime();
		long newTime = System.nanoTime();
		double nspt = 1000000000L / 30D;//Nano Seconds Per Tick
		int[] oldVals = new int[2];
		oldVals[0] = 0; oldVals[1] = 0;
		String pw;
		while(running) { //start
			delta += (newTime - oldTime) / nspt;
			oldTime = newTime;
			while(delta >= 1) { 
				delta -= 1;
				if(win.mx >= 0 && win.my >= 0) {
					board.input(win.mx, win.my, win.lClick);
					win.mx = -1;
					win.my = -1;
				}
				if(pregame) {
					boolean turnOver = true; // new boolean
					for(Ship s : board.ships[(player1Turn) ? 0 : 1]) {
						if(s.getX() > 15 || s.getY() > 15) {
							turnOver = false;
							break;
						}
					}
					if(turnOver && !player1Turn) {
						pregame = false;
						while(((pw = JOptionPane.showInputDialog("Enter Player " + ((player1Turn) ? "1" : "2") + " Password")).compareTo(pws[(player1Turn) ? 0 : 1])) != 0);
					} else if(turnOver) {
						player1Turn = !player1Turn;
						while(((pw = JOptionPane.showInputDialog("Enter Player " + ((player1Turn) ? "2" : "1") + " Password")).compareTo(pws[(player1Turn) ? 1 : 0])) != 0);
					}
				} 
				else {
					int plr = (player1Turn) ? 0 : 1;
					if(oldVals[plr] != turnCounter[plr]) {
						oldVals[plr] = turnCounter[plr];
						player1Turn = !player1Turn;
						while(((pw = JOptionPane.showInputDialog("Enter Player " + ((player1Turn) ? "1" : "2") + " Password")).compareTo(pws[(player1Turn) ? 0 : 1])) != 0);
					}
					boolean run = false;
					for(Ship s : board.ships[plr]) if(s.isAlive()) { // Runs though the ships to see if any one ship is alive
						run = true;
						break;
					}
					if(!run) running = false; // kills the program
				}
				win.repaint();// needs attention
			}
			newTime = System.nanoTime();
		} // end
		JOptionPane.showMessageDialog(null, "GAME OVER! PLAYER " + ((player1Turn) ? "1" : "2") + " WON!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		win.dispatchEvent(new WindowEvent(win, WindowEvent.WINDOW_CLOSING));
	}

}
