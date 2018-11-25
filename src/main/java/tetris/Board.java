package tetris;



import java.util.Random;
import java.util.Scanner;


public class Board implements Runnable{

	
	private static final int gridSize = 20;
	private static final int pieceTypes = 5;
	private static Piece activePiece;

	private boolean grid[][];

	public Board() {
		this.grid = new boolean[gridSize][gridSize];
	}

	public void run() {
		long start=System.currentTimeMillis();
		while(true) {
			movePiece(MoveType.DOWN);
			update();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!activePiece.canMove()) {
				break;
			}
		}
		
	}
	private void addNewPiece() {
		Random rand = new Random();
		int xPos = rand.nextInt(gridSize);
		int type = rand.nextInt(pieceTypes);
		activePiece = PieceBase
				.getInstance(PieceType.getType(type), xPos, this);
		activePiece.draw();
	}

	public void movePiece(MoveType type) {
		if (activePiece.isValidMove(type)) {
			activePiece.clear();
			activePiece.performMove(type);
			activePiece.moveDown();
			activePiece.draw();
		}
	}

	public void update() {
		clearConsole();
		for (int i = 0; i < gridSize; i++) {
			System.out.print("*");
			for (int j = 0; j < gridSize; j++) {
				if (grid[j][i]) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("*");
		}
		for (int i = 0; i < gridSize + 2; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	public final static void clearConsole() {
		for (int i = 0; i < 200; i++) {
			System.out.println();
		}
	}

	private void gameOver() {
		System.out.println("Game Over.");
		
		System.exit(0);
	}

	public void play(Board tetris) {
		addNewPiece();
		update();
		Thread thread=new Thread(tetris);
		thread.start();
		
		while (activePiece.canMove()) {
			while (true) {
				
				
				Scanner console=new Scanner(System.in);
				String input = console.next();
				switch (input) {
				case "a":
					movePiece(MoveType.LEFT);
					break;
				case "d":
					movePiece(MoveType.RIGHT);
					break;
				case "w":
					movePiece(MoveType.COUNTER_CLOCK);
					break;
				case "s":
					movePiece(MoveType.CLOCK_WISE);
					break;
				}
				update();
				if (!activePiece.canMove()) {
					
					break;
				}
			}
			addNewPiece();
			update();
		}
		gameOver();
	}

	public void set(int x, int y) {
		if (x >= 0 && x < gridSize && y >= 0 && y < gridSize) {
			this.grid[x][y] = true;
		}
	}

	public void clear(int x, int y) {
		if (x >= 0 && x < gridSize && y >= 0 && y < gridSize) {
			this.grid[x][y] = false;
		}
	}

	public boolean isClear(int i, int j, Piece p) {
		if (i < 0 || i > gridSize - 1 || j < 0 || j > gridSize - 1) {
			return false;
		}
		return !grid[i][j] || p.contains(i, j);
	}
}