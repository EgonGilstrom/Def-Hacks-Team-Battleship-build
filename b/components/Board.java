package b.components;

import java.awt.Color;
import java.awt.Graphics;

import b.components.ship.*;
import b.main.Root;
import b.main.drawable;

public class Board implements drawable {
	
	public int[][][] coords;
	public boolean[][][][] hits;//Player, x, y, [tryed location, hit]
	public Ship[][] ships;
	public int square;
	public int selected = -1;
	private Color lb;
	
	public Board() {
		lb = new Color(74, 204, 247);
		coords = new int[2][16][16];
		for(int x = 0; x < 2; x++) {
			for(int y = 0; y < 16; y++) {
				for(int z = 0; z < 16; z++) {
					coords[x][y][z] = -1;
				}
			}
		}
		hits = new boolean[2][16][16][2];
		for(int a = 0; a < 2; a++) for(int b = 0; b < 16; b++) for(int c = 0; c < 16; c++) for(int d = 0; d < 2; d++) {
			hits[a][b][c][d] = false;
		}
		ships = new Ship[2][16];
		for(int i = 0; i < 2; i++) {
			ships[i][0] = new Air(16, 0);
			ships[i][1] = new Air(17, 0);
			ships[i][2] = new Air(18, 0);
			ships[i][3] = new Battle(16, 6);
			ships[i][4] = new Battle(17, 6);
			ships[i][5] = new Battle(18, 6);
			ships[i][6] = new Battle(19, 6);
			ships[i][7] = new Cruiser(16, 10);
			ships[i][8] = new Cruiser(17, 10);
			ships[i][9] = new Cruiser(18, 10);
			ships[i][10] = new Destroyer(16, 13);
			ships[i][11] = new Destroyer(17, 13);
			ships[i][12] = new Destroyer(18, 13);
			ships[i][13] = new Submarine(16, 15);
			ships[i][14] = new Submarine(17, 15);
			ships[i][15] = new Submarine(18, 15);
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		int dim;
		if(Root.win.getWidth() >= Root.win.getHeight()) dim = Root.win.getHeight() * 12/16;
		else dim = Root.win.getWidth() * 12/16;
		square = dim / 16;
		dim = square * 16;
		int plr = (Root.player1Turn) ? 0 : 1;
		if(Root.pregame) {
			for(int i = 0; i < 16; i++) {
				g.drawRect(i * square, 0, square, dim);
				g.drawRect(0, i * square, dim, square);
			}
			g.setColor(Color.LIGHT_GRAY);
			for(Ship s : ships[plr/*(plr == 0) ? 1 : 0*/]) s.draw(g);
		} else {
			g.fillRect(0, 0, dim, dim);
			for(int x = 0; x < hits[0].length; x++) for(int y = 0; y < hits[0][x].length; y++) {
				if(!hits[plr][x][y][0]) g.setColor(lb);	
				else if(hits[plr][x][y][1]) g.setColor(Color.red);
				else g.setColor(Color.white);
				g.fillRect(square * x + 1, square * y + 1, square - 1, square - 1);
			}
		}
		g.setColor(Color.black);
	}
	
	public void hitDetect(int x, int y) {//when hit increment Root.turnCounter
		int plr = (Root.player1Turn) ? 0 : 1;
		if(x < 16 && y < 16) {
			if(!hits[plr][x][y][0]) {
				Root.turnCounter[plr] += 1;
				hits[plr][x][y][0] = true;
				if(coords[plr][x][y] != -1) {
					hits[plr][x][y][1] = true;
					ships[plr][coords[plr][x][y]].decrementHealth();
					System.out.println("Good Shot");
				} else {
					hits[plr][x][y][1] = false;
					System.out.println("Terrible Shot1");
				}
			}
		}
	}
	
	public void input(int x, int y, boolean leftClick) {
		double grid;
		if(Root.win.getWidth() >= Root.win.getHeight()) grid = (Root.win.getWidth() * 12/16);
		else grid = (Root.win.getHeight() * 12/16);
		double square = grid / 16;
		int simpleX = (int) (x / square);
		int simpleY = (int) (y / square);
		int plr = (Root.player1Turn) ? 0 : 1;
		if(Root.pregame) {
			if(x > grid || y > grid) {
				for(int i = 0; i < ships[0].length; i++) {
					if(ships[plr][i].getX() == simpleX && 
							(ships[plr][i].getY() <= simpleY && (ships[plr][i].getY() + ships[plr][i].getLength()) >= simpleY)) {
						ships[plr][i].toggledSelected();
						selected = i;
					}
				}
			} else if(selected >= 0) {
				//System.out.println(simpleX + ", " + simpleY);
				if(leftClick) {
					if(simpleY + ships[plr][selected].getLength() <= 16) {
						boolean clear = true;
						for(int i = 0; i < ships[plr][selected].getLength(); i++) if(coords[plr][simpleX][simpleY + i] != -1) clear = false;
						if(clear) {
							ships[plr][selected].toggledSelected();
							ships[plr][selected].setllToY(true);
							ships[plr][selected].setX(simpleX);
							ships[plr][selected].setY(simpleY);
							setPointers(selected);
							selected = -1;
						}
					} else {
						System.out.println("Ship Placement out of bounds, Y: " + simpleY);
					}
				} else {
					if(simpleX + ships[plr][selected].getLength() <= 16) {
						boolean clear = true;
						for(int i = 0; i < ships[plr][selected].getLength(); i++) if(coords[plr][simpleX + i][simpleY] != -1) clear = false;
						if(clear) {
							ships[plr][selected].toggledSelected();
							ships[plr][selected].setllToY(false);
							ships[plr][selected].setX(simpleX);
							ships[plr][selected].setY(simpleY);
							setPointers(selected);
							selected = -1;
						}
					} else {
						System.out.println("Ship Placement out of bounds, X: " + simpleX);
					}
				}
			}
		} else {
			hitDetect(simpleX, simpleY);
		}
	}

	private void setPointers(int shipId) {
		int plr = (Root.player1Turn) ? 0 : 1;
		for(int i = 0; i < ships[plr][shipId].getLength(); i++) {
			if(ships[plr][shipId].isllToY()) {
				coords[plr][ships[plr][shipId].getX()][ships[plr][shipId].getY() + i] = shipId;
			} else {
				coords[plr][ships[plr][shipId].getX() + i][ships[plr][shipId].getY()] = shipId;
			}
		}
	}
}
