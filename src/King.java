public class King extends ChessPiece {

    public King(int x, int y, Player owner) {
        super(x, y, owner);
        this.x=x;
        this.y=y;
        this.pieceType="king";
    }
    public ChessPiece clone(){
        return new King(x,y,owner);
    }
}

