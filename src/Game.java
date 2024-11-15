import java.sql.SQLOutput;
import java.util.*;

public class Game {
    GameBoard gb = new GameBoard();
    Scanner sc = new Scanner(System.in);
    Random AI = new Random();
    ArrayList<Integer> playerpos = new ArrayList<Integer>();
    ArrayList<Integer> AIpos = new ArrayList<Integer>();

    public void play() {

       printBoard();
       GameLoop();
       playAgain();

    }

    public void printBoard() {
        for (char[] row : gb.getBoard() ){
            for (char ch : row) {
                System.out.print(ch);
            }
           System.out.println();
        }
    }
    public void  placement(char [][] board,int playerInput,String user) {

        char symbol = ' ';

        if(user.equals("player")){
          symbol = 'X';
          playerpos.add(playerInput);
        }else if(user.equals("computer")){
          symbol = 'Y';
          AIpos.add(playerInput);
        }

        switch(playerInput){
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
        printBoard();
    }
    public void GameLoop() {
        while (true) {
            System.out.println("Enter your placement 1-9");
            int playerInput = sc.nextInt();
            System.out.println(playerInput);
            while (playerpos.contains(playerInput) || AIpos.contains(playerpos)) {
                System.out.println("Posistion is already placed! Enter a free posistion");
                playerInput = sc.nextInt();
            }
            placement(gb.board, playerInput, "player");

            int aiInput= AI.nextInt(9)+ 1;
            while (playerpos.contains(aiInput) || AIpos.contains(aiInput)) {
                aiInput = AI.nextInt(9)+ 1;
            }
            placement(gb.board, aiInput, "computer");

            String results = checkWinner();
            if (results.length() > 0) {
                System.out.println(results);
                break;
            }
            results = checkWinner();
            if (results.length() > 0) {
                System.out.println(results);
                break;
            }
        }

    }
    public String checkWinner() {
        List top = Arrays.asList(gb.board, 1, 2, 3);
        List middle = Arrays.asList(gb.board, 4, 5, 6);
        List bottom = Arrays.asList(gb.board, 7, 8, 9);
        List leftcol = Arrays.asList(gb.board, 1, 4, 7);
        List midcol = Arrays.asList(gb.board, 2, 5, 8);
        List rightcol = Arrays.asList(gb.board, 3, 6, 9);
        List cross1 = Arrays.asList(gb.board, 1, 5, 9);
        List cross2 = Arrays.asList(gb.board, 7, 5, 3);


        List<List> Wins = new ArrayList<List>();
        Wins.add(top);
        Wins.add(middle);
        Wins.add(bottom);
        Wins.add(leftcol);
        Wins.add(midcol);
        Wins.add(rightcol);
        Wins.add(cross1);
        Wins.add(cross2);


        for (List list : Wins) {
            if (playerpos.containsAll(list)) {
                return "GG good game, you won";
            } else if (AIpos.containsAll(list)) {
                return "lol get gud. AI wins!";
            } else if (playerpos.size() + AIpos.size() == 9) {
                return "You both suck";
            }
        }
      return "";
    }
    public void playAgain(){
        System.out.println("Do you want to play again? (Yes/No)");
        if (sc.next().toLowerCase().equals("y")) {
            GameLoop();
        }else if (sc.next().toLowerCase().equals("n")) {
            System.out.println("Bye bye, have a nice day!");
        }

    }

}
