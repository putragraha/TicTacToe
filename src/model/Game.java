package model;

import java.util.List;

public class Game {

    private Board board;
    private PlayerState playerState;
    private boolean isPlayerNextMove;

    public Game() {
        startGame();
    }

    private void startGame() {
        isPlayerNextMove = true;
        playerState = PlayerState.IN_PROGRESS;
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public void markTile(String tileId) {
        setTileValue(board.get(tileId));
    }

    public void markTileRandom() {
        setTileValue(board.getRandomAvailable());
    }

    private void setTileValue(Tile tile) {
        if (!isGameOver() && tile.isEmpty()) {
            tile.setValue(isPlayerNextMove ? Tile.Value.X : Tile.Value.O);
            isPlayerNextMove = !isPlayerNextMove;

            Tile.Value winValue = evaluateWinValue();
            if (winValue == null) {
                playerState = board.isFull() ? PlayerState.DRAW : PlayerState.IN_PROGRESS;
            } else {
                Tile.Value playerValue = Tile.Value.X;
                playerState = winValue == playerValue ? PlayerState.WIN : PlayerState.LOSS;
            }
        }
    }

    private Tile.Value evaluateWinValue() {
        List<List<Tile>> allLines = board.getAllLines();

        for (List<Tile> line : allLines) {
            Tile first = line.get(0);
            if (first.isEmpty()) {
                continue;
            }

            if (line.stream().allMatch(t -> t.getValue() == first.getValue())) {
                return first.getValue();
            }
        }

        return null;
    }

    private boolean isGameOver() {
        return playerState.isGameOver();
    }

    public PlayerState getPlayerState() {
        return playerState;
    }
}
