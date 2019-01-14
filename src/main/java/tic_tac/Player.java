package tic_tac;

public class Player {
	
	String name;
	String symbol;
	int[] rows = new int[3];
	int[] cols = new int[3];
	int diagnal;
	int antiDiagnal;
	boolean win = false;
	Player(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int[] getRows() {
		return rows;
	}
	public void setRows(int[] rows) {
		this.rows = rows;
	}
	public int[] getCols() {
		return cols;
	}
	public void setCols(int[] cols) {
		this.cols = cols;
	}
	public int getDiagnal() {
		return diagnal;
	}
	public void setDiagnal(int diagnal) {
		this.diagnal = diagnal;
	}
	public int getAntiDiagnal() {
		return antiDiagnal;
	}
	public void setAntiDiagnal(int antiDiagnal) {
		this.antiDiagnal = antiDiagnal;
	}
	
}
