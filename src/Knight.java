import java.util.List;
import java.util.ArrayList;

public class Knight extends ChessPiece {

    public Knight(int x, int y, Player owner, String colour) {
        super(x, y, owner,colour);
        this.x=x;
        this.y=y;
        this.pieceType="knight";
    }

    public ChessPiece clone(){
        return new Knight(x,y,owner,colour);
    }

    public List<int[]> controlledSquares(Board board) {
        List<int[]> controlled = new ArrayList<>();

        int[][] moves = {
                { 2,  1}, { 2, -1},
                {-2,  1}, {-2, -1},
                { 1,  2}, { 1, -2},
                {-1,  2}, {-1, -2}
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

