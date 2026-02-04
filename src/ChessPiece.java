abstract class ChessPiece {

    protected char pieceType;
    protected int x;
    protected int y;
    protected Player owner;
    public ChessPiece ( int x, int y, Player player) {

        this.pieceType=pieceType;
        this.x=x;
        this.y=y;
        this.owner = owner;

    }

    public void moveTo(int x, int y) {

    }
}
