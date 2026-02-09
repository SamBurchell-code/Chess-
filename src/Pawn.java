import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece{

    private boolean unmoved;
public Pawn(int x, int y, Player owner, String colour) {
    super(x, y, owner, colour);
    this.x=x;
    this.y=y;
    this.pieceType="pawn";
    this.colour=colour;
    this.unmoved=true;
}

public boolean getUnmoved() {
    return this.unmoved;
}

public void setUnmoved(boolean bool){
    this.unmoved=bool;
}

public String getColour() {
    return this.colour;
}

    public ChessPiece clone(){
        return new Pawn(x,y,owner,colour);
    }

    public List<int[]> controlledSquares(Board board) {
        List<int[]> controlled = new ArrayList<>();
        int direction;
        if(colour.equals("White")) {
            direction=1;
        }
        else {
            direction=-1;
        }
        int[][] moves = {
                { 1,  direction}, { -1, direction},
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
