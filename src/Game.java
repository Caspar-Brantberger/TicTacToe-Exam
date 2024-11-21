
import java.util.*;

public class Game {
    GameBoard gb = new GameBoard();
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> playerpos2 = new ArrayList<>();
    ArrayList<Integer> playerpos = new ArrayList<>();
    ArrayList<Integer>currentPlayer =  playerpos;


    public void play() {

        printBoard(gb.getBoard());
        GameLoop();
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
        }else if(user.equals("player2")){
            symbol = 'Y';
            playerpos2.add(pos);
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
            if(currentPlayer.equals(playerpos)) {
                System.out.println("Enter your placement 1-9, Player`s turn");
            }else{
                System.out.println("Enter your placement 1-9, Player`2s turn");
            }

            int playerInput = sc.nextInt();
            while(playerpos.contains(playerInput)||playerpos2.contains(playerInput)){
                System.out.println("Posisiton is taken, enter a valid option");
                playerInput = sc.nextInt();
            }
            if(currentPlayer.equals(playerpos)){
                placement(gb.getBoard(), playerInput, "player");
            }else{
                placement(gb.getBoard(), playerInput, "player2");
            }

            if(currentPlayer.equals(playerpos)){
               currentPlayer = playerpos2;
            }else currentPlayer = playerpos;

            printBoard(gb.getBoard());

            boolean result =checkWinnerForPlayer(gb.getBoard());

        }

    }
    public boolean checkWinnerForPlayer(char [][] board) {
        if (checkOpponent(board, 'X')) {
            printBoard(board);
            System.out.println("Player wins");
            playAgain();
            return true;
        }
        if (checkOpponent(board, 'Y')) {
            printBoard(board);
            System.out.println("Player2 wins");
            playAgain();
            return true;
        }
        else if(playerpos.size()+ playerpos2.size() == 9){
            System.out.println("Tie,nobody wins");
            playAgain();
            return true;
        }
        for(int i = 0; i < gb.getBoard().length; i++){
            for(int j= 0; j < gb.getBoard()[i].length; j++){
                if(gb.getBoard()[i][j] == ' '){
                    return false;
                }
            }
        }
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
    public boolean playAgain(){

        System.out.println("Do you wan to play again? yes/no");
        while(true){
            String input = sc.nextLine();
            if(input.toLowerCase().startsWith("y")){
                resetGame();
                return true;
            }
            if(input.toLowerCase().startsWith("n")){
                System.out.println("Shutting down program..");
                System.exit(0);
                return true;
            }
        }
    }
    public void resetGame (){
        gb =new GameBoard();
        resetVariables();
       printBoard(gb.getBoard());
    }
    public void resetVariables(){
        playerpos.clear();
        playerpos2.clear();
        currentPlayer.clear();
        currentPlayer=playerpos;
    }

}


