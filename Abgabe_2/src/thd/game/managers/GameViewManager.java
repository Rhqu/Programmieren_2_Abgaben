package thd.game.managers;

import game.ScorePanel;
import game.Ufo;
import game.UfoShot;

public class GameViewManager {
    private final GameView gameView;
    private Ufo ufo;
    private UfoShot ufoShot;
    private ScorePanel scorePanel;

    public GameViewManager() {
        gameView = new GameView();
        ufo = new Ufo(gameView);
        ufoShot = new UfoShot(gameView);
        scorePanel = new ScorePanel(gameView);
        startGameLoop();
    }

    private void startGameLoop() {
        while (gameView.isVisible()) {
            ufo.updatePosition();
            ufo.addToCanvas();
            ufoShot.addToCanvas();
            ufoShot.updatePosition();
            scorePanel.addToCanvas();
            gameView.plotCanvas();
        }
    }
}