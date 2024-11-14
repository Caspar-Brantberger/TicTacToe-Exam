public class GameBoard {
    public char [][] board =
                       {{' ','︱',' ','︱',' '},
                        {'-','+','-','+','-'},
                       {' ','︱',' ','︱',' '},
                       {'-','+','-','+','-'},
                       {' ','︱',' ','︱',' '}};

    public GameBoard() {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}



