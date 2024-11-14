import java.util.Scanner;

public class Game {
    GameBoard gb = new GameBoard();
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();

    public void play() {

       printBoard();
       placement();


    }
    public void printBoard() {
        for (char[] row : gb.getBoard() ){
            for (char ch : row) {
                System.out.print(ch);
            }
           System.out.println();
        }
    }
    public void  placement(){
        System.out.println("Enter your placement 1-9");
        input = sc.nextInt();
        System.out.println(input);

        switch(input){
            case 1:
                gb.getBoard()[0][0] = 'X';
                break;
            case 2:
                gb.getBoard()[0][2] = 'X';
                break;
            case 3:
                gb.getBoard()[0][4] = 'X';
                break;
            case 4:
                gb.getBoard()[2][0] = 'X';
                break;
            case 5:
                gb.getBoard()[2][2] = 'X';
                break;
            case 6:
                gb.getBoard()[2][4] = 'X';
                break;
            case 7:
                gb.getBoard()[4][0] = 'X';
                break;
            case 8:
                gb.getBoard()[4][2] = 'X';
                break;
            case 9:
                gb.getBoard()[4][4] = 'X';
                break;
        }
        printBoard();
    }
}
