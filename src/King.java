import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {

    public King(int x, int y, Player owner, String colour) {
        super(x, y, owner, colour);
        this.x=x;
        this.y=y;
        this.pieceType="king";
    }
    public ChessPiece clone(){
        return new King(x,y,owner, colour);
    }

    public List<int[]> controlledSquares(Board board) {
        List<int[]> controlled = new ArrayList<>();

        int[][] moves = {
                { 1,  1}, { 1, 0}, {1,-1},
                {0,  1}, {0, -1},
                { -1,  1}, { -1, 0},{-1,-1}

        };

        for (int[] m : moves) {
            int nx = x + m[0];
            int ny = y + m[1];

            if (board.inBounds(nx,ny)) {
                controlled.add(new int[]{nx, ny});
            }
        }

        return controlled;
    }
}

