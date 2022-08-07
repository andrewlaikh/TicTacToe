public class Logic {
    Turn turn = Turn.X;
    int[] xCount = new int[3], yCount = new int[3];
    int leftDiag = 0, rightDiag = 0;

    public void printTurn() {
        System.out.println("It is now " + turn.returnString() + "'s turn. Please select grid to enter");
    }

    public void printWinner() {
        System.out.println("The winner is " + turn.returnString() + ". Nice!");
    }

    public void updateTurn() {
        if(turn == Turn.X) turn = Turn.O;
        else turn = Turn.X;
    }

    public boolean hasCompleteMatches(Board board) {
        //run the array to validate the logic for complete matches
        for(int xRow: xCount) if(hasCompleteMatch(xRow)) return true;
        for(int yRow: yCount) if(hasCompleteMatch(yRow)) return true;
        if(hasCompleteMatch(leftDiag) || hasCompleteMatch(rightDiag)) return true;
        else return false;
    }

    public boolean hasCompleteMatch(int x){
        return (x == 3) || (x == -3);
    }

    public void updateLogic(int row, int col, int val){
        xCount[row] += val;
        yCount[col] += val;
        if(row == col) leftDiag += val;
        if(row == 2 - col) rightDiag += val;
    }

    public int getRow(int pos) {
        return pos/3;
    }

    public int getCol(int pos) {
        return pos % 3;
    }

    public void updateBoard(String input, Board board) {
        int pos = Integer.parseInt(input) - 1, row = getRow(pos), col = getCol(pos);
        board.updatePosition(row, col, turn.returnString());
        updateLogic(row, col, turn.returnVal());
        if(!hasCompleteMatches(board)) updateTurn();
    }
}
