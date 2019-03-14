package controller;

import message.ConsoleMessage;
import model.Game;
import model.Tile;

import java.util.Scanner;

public class Controller {
    private void markTile(Game game, String tileId) {
        game.markTile(tileId); // Player Turn
        game.markTileRandom(); // Computer Turn
    }

    public Game populateGame(ConsoleMessage message) {
        if (message.showIntro())
            return new Game();
        else
            return null;
    }

    public void startGame(Game game, ConsoleMessage consoleMessage) {
        System.out.println();
        if (game == null) {
            consoleMessage.showCanceledGameMessage();
        } else {
            consoleMessage.showAcceptedGameMessage();
            while (game.getPlayerState().isInProgress()) {
                System.out.println();
                drawBoard(game);
                inputTileId(game);
            }

            System.out.println();
            if (game.getPlayerState().isWin()) {
                consoleMessage.showVictoryMessage();
            } else if (game.getPlayerState().isLoss()) {
                consoleMessage.showDefeatMessage();
            } else if (game.getPlayerState().isDraw()) {
                consoleMessage.showDrawMessage();
            }
        }
    }

    private void drawBoard(Game game) {
        Tile[][] tiles = game.getBoard().getTiles();
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                String value = tile.isEmpty() ? "?" : tile.toString();
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private void inputTileId(Game game) {
        System.out.print("Input your tile id : ");
        Scanner input = new Scanner(System.in);
        String tileId = input.nextLine();

        if (game.getBoard().isTileIdValid(tileId))
            markTile(game, tileId);
    }
}
