public class Pawn extends ChessPiece{

public Pawn(int x, int y, Player owner) {
    super(x, y, owner);
    this.x=x;
    this.y=y;
    this.pieceType='P';
}
}
