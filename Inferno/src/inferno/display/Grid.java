package inferno.display;

public class Grid {

	private int x=16, y=13;
	private GridSquare[][] screen=null;
	
	public Grid(int x, int y) {
		//set grid size - default should be 16 x 13
		this.x=x; this.y=y;
		makeGrid();
	}	//end constructor
	
	public void makeGrid() {
		screen=new GridSquare[x][y];
	}	//

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		makeGrid();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		makeGrid();
	}
	
}	//end Grid
