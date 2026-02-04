abstract class ChessPiece implements Cloneable {

    protected String pieceType;
    protected int x;
    protected int y;
    protected Player owner;
    public ChessPiece ( int x, int y, Player player) {

        this.x=x;
        this.y=y;
        this.owner = player;

    }

    public void moveTo(int x, int y) {

    }

    public abstract ChessPiece clone();
}
