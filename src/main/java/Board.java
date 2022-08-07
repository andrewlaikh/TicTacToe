import java.util.Arrays;

public class Board {
    String[][] board = new String[3][3];

    public Board() {
        for(String[] row: board) Arrays.fill(row, " ");
    }

    public void updatePosition(int row, int col, String party){
        board[row][col] = party;
    }

    public void renderBoard() {
        for(String[] row: board){
            for(String cell: row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
