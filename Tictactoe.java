import java.util.*;
public class Tictactoe {
	static Scanner userInput = new Scanner(System.in);
	static char userLetter;
	static char computerLetter;
	static char[] board = new char[10];

	public char[] createBoard() {
		for (int i=1 ; i < 10; i++ ) {
			board[i] = ' ';
		}
		return board;
	}

	public static void chooseLetter() {
		System.out.print("Choose your Letter X or O : ");
		userLetter = userInput.next().toUpperCase().charAt(0);
		if (userLetter == 'X' || userLetter == 'x' || userLetter == 'o' || userLetter == 'O') {
			computerLetter = (userLetter == 'X') ? 'O' : 'X';
		} else {
			System.out.println("Invalid INPUT");
			chooseLetter();
		}
	}

	public static void showBoard(){
		System.out.println( "    " +board[1]+ "   | "+ board[2]+ "  | " + board[3]+ "     ");
		System.out.println(" ------------------------ ");
		System.out.println( "    " +board[4]+ "   | "+ board[5]+ "  | " + board[6]+ "     ");
		System.out.println(" ------------------------ ");
		System.out.println( "    " +board[7]+ "   | "+ board[8]+ "  | " + board[9]+ "     ");
	}

	public static void makeMove() {
		System.out.print("Select location between 1-9 : ");
		int location = userInput.nextInt();
		if (board[location] != ' ') {
			System.out.println("Position Already Occupied");
		}
      else {
			board[location] = userLetter;
		}
	}

	public static void main(String[] args){
		System.out.println("Welcome to TicTacToeGame");
		Tictactoe ticTacToeGame = new Tictactoe();
		ticTacToeGame.createBoard();
		chooseLetter();
      System.out.println("Computer Letter: " +computerLetter);
		showBoard();
		makeMove();
		showBoard();
	}
}
