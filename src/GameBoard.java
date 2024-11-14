public class GameBoard {
    public char [][] board =
                       {{'1','︱','2','︱','3'},
                        {'-','+','-','+','-'},
                       {'4','︱','5','︱','6'},
                       {'-','+','-','+','-'},
                       {'7','︱','8','︱','9'}};

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



