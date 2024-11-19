
import java.util.*;

public class Game {
    GameBoard gb = new GameBoard();
    Scanner sc = new Scanner(System.in);
    Random AI = new Random();
    ArrayList<Integer> playerpos = new ArrayList<>();
    ArrayList<Integer> AIpos = new ArrayList<>();

    public void play() {

        printBoard(gb.getBoard());
        GameLoop();
        //playAgain();

    }

    public void printBoard(char [] []board ) {
        for (char[] row : gb.getBoard() ){
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }
    public  void placement(char [][] board, int pos, String user) {

        char symbol = ' ';

        if(user.equals("player")){
            symbol = 'X';
            playerpos.add(pos);
        }else if(user.equals("computer")){
            symbol = 'Y';
            AIpos.add(pos);
        }

        switch(pos){
            case 1:
                gb.getBoard()[0][0] = symbol;
                break;
            case 2:
                gb.getBoard()[0][2] = symbol;
                break;
            case 3:
                gb.getBoard()[0][4] = symbol;
                break;
            case 4:
                gb.getBoard()[2][0] = symbol;
                break;
            case 5:
                gb.getBoard()[2][2] = symbol;
                break;
            case 6:
                gb.getBoard()[2][4] = symbol;
                break;
            case 7:
                gb.getBoard()[4][0] = symbol;
                break;
            case 8:
                gb.getBoard()[4][2] = symbol;
                break;
            case 9:
                gb.getBoard()[4][4] = symbol;
                break;
            default:
                break;
        }
        printBoard(gb.getBoard());

    }
    public void GameLoop() {
        while (true) {
            System.out.println("Enter your placement 1-9");
            int playerInput = sc.nextInt();
            while(playerpos.contains(playerInput)||AIpos.contains(playerInput)){
                System.out.println("Posisiton is taken, enter a valid option");
                playerInput = sc.nextInt();
            }

            placement(gb.board, playerInput, "player");


            int aiInput = AI.nextInt(9) + 1;
            while(playerpos.contains(AIpos)||AIpos.contains(AIpos)){
                 aiInput = AI.nextInt(9) + 1;
            }
            placement(gb.board, aiInput, "computer");

            printBoard(gb.getBoard());

           boolean result = checkWinnerForPlayer(gb.getBoard());
            System.out.println(result);

        }

    }
    public boolean checkWinnerForPlayer(char [][] board) {
        if (checkOpponent(board,'X')){
            printBoard(board);
            System.out.println("Player wins");
            return true;
        }
        if (checkOpponent(board,'Y')){
            printBoard(board);
            System.out.println("Computer wins");
            return true;
        }

        for(int i = 0; i < gb.getBoard().length; i++){
           for(int j= 0; j < gb.getBoard()[i].length; j++){
               if(gb.getBoard()[i][j] == ' '){
                   return false;
               }
           }
        }
        printBoard(board);
        System.out.println("Tie,nobody wins");
        return true;
    }
    public boolean checkOpponent(char [][] board,char symbol) {
        if ((board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) ||
                (board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) ||
                (board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) ||

                (board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) ||
                (board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) ||
                (board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) ||

                (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) ||
                (board[4][0] == symbol && board[2][2] == symbol && board[0][4] == symbol)) {
            return true;
        }
        return false;
    }


}




