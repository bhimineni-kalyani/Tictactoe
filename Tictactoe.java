public class Tictactoe {
	static char[] board = new char[10];
    public char[] createBoard() {
         for(int i=0; i<9; i++) {
            board[i] = '  ';
         }
         return board;
    }
    public static void main(String[] args) {
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.createBoard();
    }
}

