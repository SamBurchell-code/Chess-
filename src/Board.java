import java.util.List;
import java.util.ArrayList;

public class Board {

    public ChessPiece[][] squares;

    public Board(Board board) { // to create a clone of a board, in order to simulate the next move and ensure it ends in valid board state

        this.squares = new ChessPiece[9][9];

        for (int i=1; i<9; i++) {
            for (int k=1;k<9;k++) {
                ChessPiece piece = board.squares[i][k];
                if (piece != null) {
                    this.squares[i][k]=piece.clone();
                }
            }
        }

    }
    public Board (Player player1, Player player2) {
        this.squares = new ChessPiece[9][9];

        squares[1][1] = new Rook(1,1, player1 );
        squares[1][2] = new Knight (1,2, player1);
        squares[1][3] = new Bishop(1,3, player1);
        squares[1][4] = new Queen(1,4,player1);
        squares[1][5] = new King (1,5,player1);
        squares[1][6] = new Bishop(1,6,player1);
        squares[1][7] = new Knight(1,7,player1);
        squares[1][8] = new Rook(1,8,player1);
        for (int i=1;i<9;i++) {
            squares[2][i] =new Pawn (2,i,player1, "White");
            squares[7][i] = new Pawn( 7, i,player2,"Black");
        }
        squares[8][1] = new Rook(8,1,player2);
        squares[8][2] = new Knight (8,2,player2);
        squares[8][3] = new Bishop(8,3,player2);
        squares[8][4] = new Queen(8,4,player2);
        squares[8][5] = new King (8,5,player2);
        squares[8][6] = new Bishop(8,6,player2);
        squares[8][7] = new Knight(8,7,player2);
        squares[8][8] = new Rook(8,8,player2);
    }

    public String pieceAt(int x, int y) {
        if(squares[x][y]==null) {
            return null;
        }
        return squares[x][y].pieceType;
    }

    public Player ownerAt(int x, int y) {
        return squares[x][y].owner;
    }

    public boolean inBounds(int x, int y) {
        return (x >= 1 && x<= 8 && y >= 1 && y <= 8);
    }
    public boolean isOccupied(int x, int y){
        if(!inBounds(x,y)) {
            return false;
        }

        return ( squares[x][y]!=null);
    }

    public boolean isInCheck() {

        return false;
    }

    public boolean move(int sourceX, int sourceY, int targetX, int targetY) {

        List<int[]> possibilities = squares[sourceX][sourceY].controlledSquares(this);
        boolean possible = false;
        for( int[] p : possibilities) {
            if(p[0]==targetX &&p[1]==targetY){
                possible=true;
            }
        }
        if(possible){
        squares[targetX][targetY] =squares[sourceX][sourceY];
        squares[sourceX][sourceY]=null;

        return true;}
        System.out.println("invalid move,try again");
        return false;

    }

    public void print() {
       String output="";
        for (int i=8;i>0;i--) {
            for (int k=1;k<9;k++) {
                ChessPiece piece = squares[i][k];

                if(piece==null) {
                    output+= "_";
                    continue;
                }
                switch (piece) {
                    case Rook r -> output += "R";
                    case Pawn p -> output += "P";
                    case Bishop b -> output += "B";
                    case Knight n -> output += "N";
                    case Queen q -> output += "Q";
                    case King K -> output += "K";
                    default -> output += "_"; // empty square
                }

            }
            output+="\n";
        }
        System.out.println(output);
    }
}
