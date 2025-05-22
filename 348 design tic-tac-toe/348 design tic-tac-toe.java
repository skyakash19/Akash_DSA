public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int size;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        size = n;
    }

    public int move(int row, int col, int player) {
        int playerValue = (player == 1) ? 1 : -1;
        
        rows[row] += playerValue;
        cols[col] += playerValue;
        
        if (row == col) {
            diagonal += playerValue;
        }
        
        if (row + col == size - 1) {
            antiDiagonal += playerValue;
        }
        
        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size ||
            Math.abs(antiDiagonal) == size) {
            return player;
        }
        
        return 0;
    }
}
