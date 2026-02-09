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
        squares[2][1] = new Knight (2,1, player1);
        squares[3][1] = new Bishop(3,1, player1);
        squares[4][1] = new Queen(4,1,player1);
        squares[5][1] = new King (5,1,player1);
        squares[6][1] = new Bishop(6,1,player1);
        squares[7][1] = new Knight(7,1,player1);
        squares[8][1] = new Rook(8,1,player1);
        for (int i=1;i<9;i++) {
            squares[i][2] =new Pawn (i,2,player1, "White");
            squares[i][7] = new Pawn( i,7,player2,"Black");
        }
        squares[1][8] = new Rook(1,8,player2);
        squares[2][8] = new Knight (2,8,player2);
        squares[3][8] = new Bishop(3,8,player2);
        squares[4][8] = new Queen(4,8,player2);
        squares[5][8] = new King (5,8,player2);
        squares[6][8] = new Bishop(6,8,player2);
        squares[7][8] = new Knight(7,8,player2);
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

        if (squares[sourceX][sourceY] instanceof Pawn) {
            return movePawn(sourceX, sourceY, targetX, targetY);

        }
        if(squares[targetX][targetY]!=null){
        if(squares[sourceX][sourceY].getColour().equals(squares[targetX][targetY].getColour())){
            System.out.println("you already have a piece there");
            return false;
        }}

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

    public boolean movePawn(int sourceX, int sourceY, int targetX, int targetY) {

        Pawn pawn = (Pawn) squares[sourceX][sourceY];
        int direction=0;
        switch (pawn.getColour()){
            case "White": direction=1; break;
            case "Black": direction=-1; break;
            default:{
                    System.out.println("Problem with switch statement in movePawn");
                    return false;
            }
        }
        if (sourceX==targetX && targetY==sourceY+direction && squares[targetX][targetY]==null) { //moving pawn one square forward
            squares[targetX][targetY]=squares[sourceX][sourceY];
            squares[sourceX][sourceY]=null;

            pawn.setUnmoved(false);
            return true;
        }
        else if (sourceX==targetX && targetY==sourceY+(2*direction) && squares[targetX][targetY]==null&& pawn.getUnmoved() &&squares[targetX][sourceY+direction]==null) { //moving two steps forward

            squares[targetX][targetY]=pawn;
            squares[sourceX][sourceY]=null;
            pawn.setUnmoved(false);
            return true;
        }
        else if(squares[targetX][targetY]==null) {
            System.out.println("nothing for the pawn to capture, or invalid square");
        }
        else if ((targetX==sourceX+1 || targetX==sourceX-1) && targetY==sourceY+direction && !squares[targetX][targetY].getColour().equals(pawn.getColour())){ //capture diagonally
            squares[targetX][targetY]=pawn;
            squares[sourceX][sourceY]=null;
            pawn.setUnmoved(false);
            return true;
        }



        return false;
    }

    public void print() {
       String output="";
        for (int i=8;i>0;i--) {
            for (int k=1;k<9;k++) {
                ChessPiece piece = squares[k][i];

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
