package ms;

import java.util.Scanner;

public class MSRunner {
	static Scanner keyboard = new Scanner(System.in);
	static MS game;
	public static void nextGame() throws Exception {
		
		while(true){
			
			try {
				System.out.println("Do you want to start a new GAME? type 'y' or 'n'");
				String input=keyboard.nextLine();
				if(input.equalsIgnoreCase("y")||input.equalsIgnoreCase("n")) {
					if("y".equalsIgnoreCase(input)){
						System.out.println("Enter Board size ");
						int size = keyboard.nextInt();
						System.out.print("Enter no of mines to be placed");
						int mines = keyboard.nextInt();
						game = new MS(size,size,mines);
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

	public static void run() throws Exception {
		
		int x = 0, y = 0;
		while (true) {
			try {
				System.out.println("\nEnter the x coordinate");
				x = keyboard.nextInt();
				System.out.println("\n Enter the y coordinate");
				y = keyboard.nextInt();
				game.check(x, y);
				game.victory();
				if (game.end) {
					if (game.won) {
						System.out.println("YOU WON");
					} else {

						game.endGame();
						System.out.println("YOU LOOSE ");
					}
					break;
				}
				MS.printBoard(game.getBoard());
			}
			catch(Exception e) {
				System.out.println("Enter a valid number ");
			}
		
		}
		
	}
}
