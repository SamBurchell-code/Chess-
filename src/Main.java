//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Player Sam = new Player (1, "Sam");
    Player Odi = new Player (2, "Oditwo");

    Game firstGame = new Game(Odi, Sam);
    firstGame.pieceAt(5,2);
    System.out.println("The piece at position " + "1"+"," +"2"+" is " + firstGame.pieceAt(1,2));

}
