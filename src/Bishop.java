public class Bishop extends ChessPiece {

    public Bishop(int x, int y, Player owner) {
        super(x, y, owner);
        this.x=x;
        this.y=y;
        this.pieceType="bishop";
    }

    public ChessPiece clone(){
        return new Bishop(x,y,owner);
    }

}

