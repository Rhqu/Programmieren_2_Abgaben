package thd.game.managers;

import thd.game.utilities.GameView;

public class GameViewManager {
    private final GameManager gameManager;
    private final GameView gameView;

    public GameViewManager() {
        this.gameView = new GameView();
        gameManager = new GameManager(gameView);
        startGameLoop();
    }

    private void startGameLoop() {
        while (gameView.isVisible()) {
            gameManager.processFrame();
            gameView.plotCanvas();
        }
    }
}