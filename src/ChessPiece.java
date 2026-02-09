import java.util.List;

abstract class ChessPiece implements Cloneable {

    protected String pieceType;
    protected int x;
    protected int y;
    protected Player owner;
    protected String colour;
    public ChessPiece ( int x, int y, Player player, String colour) {

        this.x=x;
        this.y=y;
        this.owner = player;
        this.colour=colour;

    }

    public ChessPiece ( int x, int y, Player player) {

        this.x=x;
        this.y=y;
        this.owner = player;
        this.colour=colour;

    }
    public String getColour() {
        return this.colour;
    }

    public void moveTo(int x, int y) {

    }

    public abstract ChessPiece clone();

    public abstract List<int[]> controlledSquares(Board board);
}
