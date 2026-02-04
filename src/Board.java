public class Board {

    private ChessPiece[][] squares;

    public Board () {
        this.squares = new ChessPiece[9][9];

        squares[1][1] = new Rook(1,1);
        squares[1][2] = new Knight (1,2);
        squares[1][3] = new Bishop(1,3);
        squares[1][4] = new Queen(1,4);
        squares[1][5] = new King (1,5);
        squares[1][6] = new Bishop(1,6);
        squares[1][7] = new Knight(1,7);
        squares[1][8] = new Rook(1,8);
        for (int i=1;i<9;i++) {
            squares[2][i] =new Pawn (2,i);
            squares[7][i] = new Pawn( 7, i);
        }
        squares[8][1] = new Rook(8,1);
        squares[8][2] = new Knight (8,2);
        squares[8][3] = new Bishop(8,3);
        squares[8][4] = new Queen(8,4);
        squares[8][5] = new King (8,5);
        squares[8][6] = new Bishop(8,6);
        squares[8][7] = new Knight(8,7);
        squares[8][8] = new Rook(8,8);
    }

    public char pieceAt(int x, int y) {
        return squares[x][y].pieceType;
    }
}
