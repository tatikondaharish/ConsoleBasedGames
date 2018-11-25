package tic_tac;

import java.util.Scanner;



public class TestGame {
	static Scanner keyboard=new Scanner(System.in);
	TTT game;
	public void nextGame() {
	while(true){
			
			try {
				System.out.println("Do you want to start a new GAME? type 'y' or 'n'");
				String input=keyboard.nextLine();
				if(input.equalsIgnoreCase("y")||input.equalsIgnoreCase("n")) {
					if("y".equalsIgnoreCase(input)){
						game = new TTT();
						run();
					}
					else {
						break;
					}
				}
				else {
					throw new Exception();
				}
				
			}
		catch(Exception e) {
			System.out.println("Enter a valid input ");
			
		}
		}
	}
	
	public void run() {
		game.playersSetup();
		TTT.printBoard(game.getBoard());
		int moves=game.getBoard().length;
		moves=moves*moves;
		while(moves>0) {
			game.turn(1);
			if(game.result(1)) {
				System.out.println("wins\n");
				
				break;
			}
			TTT.printBoard(game.getBoard());
			game.turn(2);
			if(game.result(2)) {
				System.out.print("wins");
				break;
			}
			TTT.printBoard(game.getBoard());
			moves-=2;
		}
	}
	
	public static void main(String[] args) {
		new TestGame().nextGame();
		
	}
}