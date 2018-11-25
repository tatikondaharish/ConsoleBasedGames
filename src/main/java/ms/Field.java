package ms;

public class Field {
	private final boolean mine;
	private boolean revealed;
	private int neighbours;
	
	Field(boolean mine){
		this.mine=mine;
		this.setRevealed(false);
		this.setNeighbours(0);
	}

	public boolean isMine() {
		return mine;
	}

	public boolean isRevealed() {
		return revealed;
	}

	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}

	public int getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(int neighbours) {
		this.neighbours = neighbours;
	}
}
