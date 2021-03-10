import java.util.*;
public class Tictactoe {
	static Scanner userInput = new Scanner(System.in);
	static char userLetter;
	static char computerLetter;
	static char[] board = new char[10];
	static int count = 0;
	static int index;
	static int chance;

	static ArrayList<int[]> checkCondition = new ArrayList<>();

	public static void conditionsForWin() {
	   int[] cond0 = {1, 2, 3};
		int[] cond1 = {4, 5, 6};
		int[] cond2 = {7, 8, 9};
		int[] cond3 = {1, 4, 7};
		int[] cond4 = {2, 5, 8};
		int[] cond5 = {3, 6, 9};
		int[] cond6 = {1, 5, 9};
		int[] cond7 = {3, 5, 7};

		checkCondition.add(cond0);
		checkCondition.add(cond1);
		checkCondition.add(cond2);
		checkCondition.add(cond3);
		checkCondition.add(cond4);
		checkCondition.add(cond5);
		checkCondition.add(cond6);
		checkCondition.add(cond7);
	}

	public void createBoard() {
		for(int i=1 ; i < 10; i++ ) {
			board[i] = ' ';
		}
	}

	public static void chooseLetter() {
		System.out.print("Choose your Letter X or O : ");
		userLetter = userInput.next().toUpperCase().charAt(0);
		if (userLetter == 'X' || userLetter == 'x' || userLetter == 'o' || userLetter == 'O') {
			computerLetter = (userLetter == 'X') ? 'O' : 'X';
		}
      else {
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
			makeMove();
		}
      else {
			board[location] = userLetter;
		}
	}

	public static void toss() {
	   System.out.println("Toss Time press 0 ");
		int check = userInput.nextInt();
   	chance =(int) (Math.random() * 2);
		if (chance == check) {
			System.out.println("You Won the Toss");
   	}
      else {
			System.out.println("You Lose the Toss");
   	}
	}

	public static char winCheck() {
		final int WIN_CONDITION = 3;
		for (int index = 0; index < checkCondition.size(); index++) {
			int addX = 0;
			int addO = 0;
			for (int i = 0; i < checkCondition.get(index).length; i++) {
				if (board[checkCondition.get(index)[i]] == 'X') {
					addX += 1;
					if (addX == WIN_CONDITION) {
						return 'X';
					}
				} 
            else if (board[checkCondition.get(index)[i]] == 'O') {
					addO += 1;
					if (addO == WIN_CONDITION) {
						return 'O';
					}
				}
	      }
		}
		return ' ';
	}

	public static boolean tie() {
		for (int k = 1; k < 10; k++) {
			if (board[k] == ' ') {
				return false;
			}
		}
		return true;
	}

	public static void turn() {
		while (true) {
			if (winCheck() == 'X' || winCheck() == 'O') {
				System.out.println((userLetter == winCheck()) ? "You Win" : "Computer Wins");
				break;
			}
         else if (tie()) {
				System.out.println("It's a tie");
				break;
			}
         else {
				if (count%2 == chance) {
					System.out.println("Your Turn");
					makeMove();
					showBoard();
				}
            else {
					System.out.println("Computer Turn");
					computerTurn();
					showBoard();
				}
				count++;
			}
		}
	}

	public static boolean checkCond(char alpha) {
	for (index = 0; index < checkCondition.size(); index++) {
			int sum = 0;
			for (int j = 0; j < checkCondition.get(index).length; j++) {
         	if (board[checkCondition.get(index)[j]] == alpha) {
					sum += 1;
					if (sum == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean compWinning() {
		if (checkCond(computerLetter)) {
			for (int l = 0; l < checkCondition.get(index).length; l++) {
				if (board[checkCondition.get(index)[l]] == ' ') {
					board[checkCondition.get(index)[l]] = computerLetter;
						return true;
				}
			}
		}
		return false;
	}

	public static boolean block() {
		if (checkCond(userLetter)) {
			for (int l = 0; l < checkCondition.get(index).length; l++) {
				if (board[checkCondition.get(index)[l]] == ' ') {
					board[checkCondition.get(index)[l]] = computerLetter;
						checkCondition.remove(index);
							return true;
				}
			}
		}
		return false;
	}

	public static void compMove() {
	int[] corner = {1, 3, 7, 9};
	int centre = 5;
	int[] sides = {2, 4, 6, 8};

		boolean check = true;
			for (int l=0; l<corner.length; l++) {
				if(board[corner[l]] == ' ') {
					board[corner[l]] = computerLetter;
				check = false;
					break;
				}
			}
			if (check) {
				if (board[centre] == ' ') {
					board[centre] = computerLetter;
					check = false;
				}
			}
			if (check) {
				for(int l=0; l<sides.length; l++) {
					if (board[sides[l]] == ' ') {
						board[sides[l]] = computerLetter;
						break;
					}
				}
			}
	}

	 public static void computerTurn() {
		if (compWinning()) {
		} 
      else if(block()) {
		}
      else {
			compMove();
		}
	}

	public static void execute() {
			Tictactoe tictactoeGame = new Tictactoe();
			conditionsForWin();
			tictactoeGame.createBoard();
			chooseLetter();
   	   System.out.println("Computer Letter: " +computerLetter);
			showBoard();
			toss();
			turn();
	}

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to TicTacToeGame");
			execute();
		}
      catch(Exception e) {
			System.out.println("Invalid Inputs Play Again");
			execute();
		}
	}
}
