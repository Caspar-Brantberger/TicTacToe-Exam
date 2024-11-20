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

    public char[][] setBoard() {
        this.board = board;
        return null;
    }
}



