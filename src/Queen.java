public class Queen extends ChessPiece {

    public Queen(int x, int y, Player owner) {
        super(x, y,owner);
        this.x=x;
        this.y=y;
        this.pieceType="queen";
    }

    public ChessPiece clone(){
        return new Queen(x,y,owner);
    }

}

