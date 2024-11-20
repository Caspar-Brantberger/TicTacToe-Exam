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

    public char[][] setBoard() {
        this.board = board;
        return null;
    }
}



