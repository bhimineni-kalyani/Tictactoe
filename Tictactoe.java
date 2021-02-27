import java.util.Scanner;
public class TictactoeUC02 {
	 static char board[] = new char[10];
	    private static char computer;
	    private static char player;
	    private static void createBoard() {
	        for(int i=0; i<9; i++)
	        board[i] = '  ';
	    }
	    private static void choose() {
	    	Scanner sc = new Scanner(System.in);
	        System.out.print("choose X or O : ");
	        player = sc.next().charAt(0);
	        if(player == 'X')
	            computer = 'O';
	        else if(player == 'O')
	            computer = 'X';
	        else {
	            System.out.println("Invalid input enter again");
	            choose();
	        }
	    }
	    public static void main(String args[]) {
	        createBoard();
	        choose();
	        System.out.println("computer" +computer);
	        System.out.println("player" +player);
	    }
}
