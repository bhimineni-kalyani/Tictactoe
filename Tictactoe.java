import java.util.Scanner;
public class TictactoeUC03 {
	private static char board[] = new char[10];
    private static char computer;
    private static char player;
    public static char[] createboard() {
        for(int a=0; a<9; a++) {
            board[a] = ' ';
        }
        System.out.println("|---|---|---|");
        System.out.println("|   |   |   |");
        System.out.println("|---|---|---|");
        System.out.println("|   |   |   |");
        System.out.println("|---|---|---|");
        System.out.println("|   |   |   |");
        return board;
    }
    private static void choose() {
        Scanner sc = new Scanner(System.in);
        System.out.print("choose X or O : ");
        char player = sc.next().charAt(0);
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
       createboard();
       choose();
       System.out.println("computer" +computer);
       System.out.println("player" +player);
    }
}
