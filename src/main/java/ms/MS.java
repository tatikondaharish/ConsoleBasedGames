package ms;

public class MS {

	private Field[][] board;
	public boolean end=false;
	public boolean won=false;
	MS(int x,int y,int mines){
		board=new Field[x][y];
		generateMines(mines);
		init();
		printBoard(board);
	}
	
	public void init() {
		System.out.println("intitalize ");
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==null) {
					board[i][j]=new Field(false);
				}
			}
		}
	}
	
	public void generateMines(int mines) {
		System.out.println("mines");
		while(mines>0) {
				int x=(int)(10*Math.random());
				int y=(int)(10*Math.random());
				if(x>=0&&x<board.length&&y>=0&&y<board.length) {
					if(board[x][y]==null) {
						board[x][y]=new Field(true);
						mines--;
					}
				}
			}
		}
	
	public static void printBoard(Field[][] board) {
		System.out.print("   ");
		for(int i=0;i<board.length;i++) {
			System.out.printf("%d ",i);
		}
		System.out.println();
		for(int i=0;i<board.length;i++) {
			System.out.printf("%2d",i);
			for(int j=0;j<board.length;j++) {
				
				System.out.print("|");
				if(board[i][j].isRevealed()) {
					System.out.print(board[i][j].getNeighbours());
							
				}
				else {
					System.out.print("-");
				}
					
			}
			System.out.printf("|%d\n",i);
		}
		System.out.print("   ");
		for(int i=0;i<board.length;i++) {
			System.out.printf("%d ",i);
			
		}
		
	}
	
	public void check(int x,int y) {
		if(board[x][y].isMine()) {
			end=true;
			
		}
		else {
			move(x,y);
		}
	}
	
	public void move(int x,int y) {
		if(x<0||x>board.length-1||y<0||y>board.length-1||board[x][y].isRevealed())
					return;
			int count=getNeighbours(x,y);
			if(count==0) {
				for(int i=-1;i<=1;i++) {
					for(int j=-1;j<=1;j++) {
						move(x+i,y+j);
					}
				}
			}
			else {
				board[x][y].setNeighbours(count);
			}
		}
	
	public int getNeighbours(int x,int y) {
		board[x][y].setRevealed(true);
		int num=0;
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				
				int di=x+i,dj=y+j;
				if(di<1||di>board.length-2||dj<1||dj>board.length-2)
					continue;
				if(board[di][dj].isMine())
					num++;
			}
		}
		return num;
	}
	
	public Field[][] getBoard(){
		return this.board;
	}
	public void victory() {
		for(int i=1;i<board.length-1;i++) {
			for(int j=1;j<board.length-1;j++) {
				if(!board[i][j].isRevealed()&&!board[i][j].isMine()) {
					return;
					
				}
				
			}
		}
		end=true;
		won=true;
		System.out.println("hurrey");
	}
	public void endGame() {
		for(int i=0;i<board.length;i++) {
			System.out.print("  "+i);
		}
		System.out.println();
		for(int i=0;i<board.length;i++) {
			System.out.print(i);
			for(int j=0;j<board.length;j++) {
				
				if(board[i][j].isRevealed()) {
					
					System.out.print("["+" "+"]");
				}
				else if(board[i][j].isMine()) {
					System.out.print("[*]");
				}
				else {
					System.out.print("[?]");
				}
			}
			System.out.println(i);
		}
	for(int i=0;i<board.length;i++) {
		System.out.print("  "+i);
	}
}
}
