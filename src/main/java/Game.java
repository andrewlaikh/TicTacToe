import java.util.Scanner;

public class Game {
    final String welcomeMessage = "Welcome to Tic-Tac-Toe! Press 'Y/y' to start";
    final String exitMessage = "Game exited. Have a good day!";
    final Scanner scanner = new Scanner(System.in);

    public void welcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void exitMessage() {
        System.out.println(exitMessage);
    }

    public String getInput() {
        return this.scanner.nextLine();
    }

    public Boolean isStart(String input){
        if(input.equals("Y") || input.equals("y")) return true;
        else return false;
    }

    public static void main(String[] args){
        Game game = new Game();
        Board board = new Board();
        Logic logic = new Logic();
        game.welcomeMessage();
        String input = game.getInput();
        if(game.isStart(input) && !logic.hasCompleteMatches(board)) {
            while(!logic.hasCompleteMatches(board)) {
                board.renderBoard();
                logic.printTurn();
                String turn = game.getInput();
                logic.updateBoard(turn, board);
            }
        }
        board.renderBoard();
        if(logic.hasCompleteMatches(board)) logic.printWinner();
        game.exitMessage();
    }
}
