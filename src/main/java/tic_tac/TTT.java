package tic_tac;

import java.util.Scanner;

public class TTT {
	Scanner keyboard=new Scanner(System.in);
	public String[][] board=new String[3][3];
	Player player1;
	Player player2;
	Player player;
	public TTT() {
		
	}
	
	public void playersSetup() {
		
		System.out.println("Enter player 1 name ");
		String name=keyboard.nextLine();
		player1=new Player(name,"X");
		System.out.println("Enter player 2 name");
		name=keyboard.nextLine();
		player2=new Player(name,"O");
		
	}
	
	public static void printBoard(String[][] board) {
		
		for(int i=0;i<board.length;i++) {
			
			for(int j=0;j<board.length;j++) {
				if(j>0&&j<board.length) {
					System.out.print("|");
				
				}
				else {
					System.out.println();
				}
				if(board[i][j]!=null) {
					System.out.print(board[i][j]);
				}
				else {
					System.out.print("-");
				}
			}
		}
	}

	public void turn(int num) {
		int x=0,y=0;
		while(true) {
			try {
				player=num==1?player1:player2;
				System.out.println("\n"+player.getName()+" Please enter the X coordinate");
				x=keyboard.nextInt();
				
				System.out.println("\n"+player.getName()+" Please enter the Y coordinate");
				y=keyboard.nextInt();
				
				if(x<0||x>board.length||y<0||y>board.length||board[x][y]!=null) {
					System.out.println("\n Please enter a valid cell coordinates");
					continue;
				}
				else {
					board[x][y]=player.symbol;
					player.rows[x]++;
					player.cols[y]++;
					if(x==y) {
						player.diagnal++;
					}
					if(y==(board[0].length-x-1)) {
						player.antiDiagnal++;
					}
					int size=board.length;
					if(player.rows[x]==size||player.cols[y]==size||player.diagnal==size
							||player.antiDiagnal==size) {
						player.win=true;
						System.out.println(player.name);
					}
					break;
				}
			}
			catch(Exception e) {
				System.out.println("Enter a valid input ");	
			}
		}
		
		
	}
	
	public boolean result(int num) {
		Player player=num==1?player1:player2;
		return player.win;
	}
	
	public String[][] getBoard() {
		return board;
	}

}
