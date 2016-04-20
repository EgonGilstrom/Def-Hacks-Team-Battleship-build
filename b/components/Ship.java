package b.components;

import b.main.drawable;

public interface Ship extends drawable {
	
	public boolean isAlive();
	public void kill();
	
	public int getLength();
	
	public int getHealth();
	public void decrementHealth();
	
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	
	public boolean isllToY();
	public void setllToY(boolean p);
	
	public void toggledSelected();
	
}
