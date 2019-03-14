import controller.Controller;
import message.ConsoleMessage;
import model.Game;

public class Main {
    public static void main(String[] args) {
        initGame();
    }

    private static void initGame() {
        ConsoleMessage consoleMessage = new ConsoleMessage();
        Controller tictactoeController = new Controller();
        Game game = tictactoeController.populateGame(consoleMessage);
        tictactoeController.startGame(game, consoleMessage);
    }
}
