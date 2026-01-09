package Practical20;

public class SierpinskiCarpet {

    private final char[][] board;
    private final int size;

    //class constructor
    //params of the board size
    public SierpinskiCarpet(int size) {
        this.size = size;
        board = new char[size][size];
        initialiseBoard();
        generateCarpet(board, 0, 0, size, 0);
    }

   //O(n^2) due to double loop to initialise all array board elements to a .
    private void initialiseBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }
    }


    //Function used to generate the carpet
    //Lots of suboptimal elements in this code as each recursive call adds two O(n^2)
    private void generateCarpet(char[][] board, int row, int col, int currentSize, int level) {

        // Base case
        //returns when no longer divisible
        if (currentSize < 5) {
            return;
        }

        int subSize = currentSize / 5;

        // Remove the central array at [2][2]
        for (int i = row + 2 * subSize; i < row + 3 * subSize; i++) {
            for (int j = col + 2 * subSize; j < col + 3 * subSize; j++) {
                board[i][j] = (char) ('0' + level);
            }
        }

        // Recurse into the remaining 24 arrays
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                // Skip the removed center
                if (r == 2 && c == 2) continue;
                generateCarpet(board, row + r * subSize, col + c * subSize, subSize, level + 1
                );
            }
        }
    }

    //prints the board in o(n^2)
    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }


     //Generates Sierpiński carpets of size 5x5, 25x25, and 125x125
    public static void main(String[] args) {

        int[] sizes = {5, 25, 125};

        //loops through and prints the different sizes
        for (int size : sizes) {
            System.out.println("\nSierpiński Carpet " + size + "x" + size + "\n");
            SierpinskiCarpet carpet = new SierpinskiCarpet(size);
            carpet.printBoard();
        }
    }
}
