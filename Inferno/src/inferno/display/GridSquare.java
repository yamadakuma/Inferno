package inferno.display;

public class GridSquare {
	
	String contents="empty";
	
	public GridSquare(String cont) {
		contents=cont;
	}	//end constructor

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
}	//end GridSquare
