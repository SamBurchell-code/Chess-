public class Rook extends ChessPiece {

    public Rook(int x, int y, Player owner) {
        super(x, y, owner);
        this.x=x;
        this.y=y;
        this.pieceType="rook";
    }
    public ChessPiece clone(){
        return new Rook(x,y,owner);
    }
}

