package thd.game.managers;

import thd.game.utilities.GameView;

/**
 * Manages the GameView and starts the game loop.
 */

public class GameViewManager {
    private final GameManager gameManager;
    private final GameView gameView;

    /**
     * Creates the GameView, game objects, and starts the game loop.
     */

    public GameViewManager() {
        this.gameView = new GameView();
        gameManager = new GameManager(gameView);
        gameView.updateWindowTitle("Super Mario Bros");
        gameView.updateStatusText("Ivan Dudkin - Java Programmierung SS 2026");
        gameView.updateWindowIcon("mario.png");
        startGameLoop();
    }

    private void startGameLoop() {
        while (gameView.isVisible()) {
            gameManager.processFrame();
            gameView.plotCanvas();
        }
    }
}