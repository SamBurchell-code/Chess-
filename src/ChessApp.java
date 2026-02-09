import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessApp extends Application{

    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;
    private GridPane boardGrid;
    private Board board;

    private void drawBoard() {
        boardGrid.getChildren().clear();


        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                StackPane square = new StackPane();
                Rectangle rect = new Rectangle(TILE_SIZE, TILE_SIZE);
                if ((row + col) % 2 == 0) {
                    rect.setFill(Color.BEIGE);
                } else {
                    rect.setFill(Color.SADDLEBROWN);
                }
                square.getChildren().add(rect);

                ChessPiece piece = board.squares[col + 1][8 - row];
                if (piece != null) {
                    String imageFile = "/images/" + piece.getColour() + "_" + piece.getPieceType() + ".png";
                    System.out.println(imageFile);
                    Image pieceImg = new Image(getClass().getResourceAsStream(imageFile));
                    if (pieceImg.isError()) {
                        System.out.println("error with " + imageFile);
                    }
                    ImageView pieceImage = new ImageView(pieceImg);
                    pieceImage.setFitWidth(TILE_SIZE);
                    pieceImage.setFitHeight(TILE_SIZE);
                    square.getChildren().add(pieceImage);
                }


                boardGrid.add(square, col, row);
            }
        }
    }
    @Override
    public void start(Stage primaryStage) {
        Player Sam = new Player(1, "Sam");
        Player Odi = new Player(2, "Oditwo");

        Game firstGame = new Game(Odi, Sam);


        board =firstGame.getBoard();

if(board==null) {
    System.out.println("board is null");
}
        boardGrid = new GridPane();
drawBoard();


        Scene scene = new Scene(boardGrid, TILE_SIZE * BOARD_SIZE, TILE_SIZE*BOARD_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chess");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
