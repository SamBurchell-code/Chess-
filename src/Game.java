
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer=player1;
        this.board = new Board();
        boolean gameover=false;
        while (gameover==false) {

            Scanner scan = new Scanner(System.in);
            System.out.println("What type of piece do you want to move? Please use lowercase.");
            String pieceType = scan.next();
            int sourceX=0;
            int sourceY=0;
            int targetX;
            int targetY;

            if (!(pieceType.equals("pawn") || pieceType.equals("knight") || pieceType.equals("bishop") || pieceType.equals("rook") || pieceType.equals("Queen") || pieceType.equals("King"))) {
                System.out.println("Invalid piece type selected. Please restart your move");
                continue;
            }


            System.out.println("What square is it on now? Use Chess algebraic notation");
            String source = scan.next();
            if (source.length() !=2) {
                System.out.println("Invalid input. Please restart your move");
            }

            char firstChar =source.charAt(0);
            firstChar = Character.toLowerCase(firstChar);

            if (firstChar < 'a' || firstChar > 'h') {
                System.out.println("That is not a valid column.");
                continue;
            }

            sourceX = firstChar - 'a' + 1;

            char secondChar = source.charAt(1);

            if(secondChar < '1' || secondChar > '8') {
                System.out.println("That is not a valid row. Please restart your move");
                continue;
            }
            sourceY=secondChar-'0';

            System.out.println("You are moving the piece on " + sourceX + ","+ sourceY);

            System.out.println("What square do you want to move it to?");
            String target = scan.next ();


        }
    }

        public char pieceAt ( int x, int y){

            return board.pieceAt(x, y);
        }
    }



