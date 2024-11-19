public class GameBoard {
    public char [][] board =
                    {{' ','︱',' ','︱',' '},
                    {'-','+','-','+','-'},
                    {' ','︱',' ','︱',' '},
                    {'-','+','-','+','-'},
                    {' ','︱',' ','︱',' '}};

    public GameBoard() {

    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}



