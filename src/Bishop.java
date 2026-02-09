import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {

    public Bishop(int x, int y, Player owner, String colour) {
        super(x, y, owner, colour);
        this.x = x;
        this.y = y;
        this.pieceType = "bishop";
    }

    public ChessPiece clone() {
        return new Bishop(x, y, owner,colour);
    }

    public List<int[]> controlledSquares(Board board) {
        List<int[]> controlled = new ArrayList<>();

        int[][] dirs = { //the directions a bishop can move
                { 1,  1},
                { 1, -1},
                {-1,  1},
                {-1, -1}
        };

        for (int[] d : dirs) { //for each direction
            int nx = x + d[0]; //adjust the x in that direction
            int ny = y + d[1]; //adjust the y in that direction

            while (board.inBounds(nx,ny)) { //while new x and new y are within bounds
                controlled.add(new int[]{nx, ny}); //add the square

                if (board.isOccupied(nx,ny)) {
                    break; //if there is a piece on that square, we go no further in this direction
                }

                nx += d[0]; //continue moving in that direction, if not stopped by previous if-statement
                ny += d[1];
            }
        }

        return controlled;
    }
}

