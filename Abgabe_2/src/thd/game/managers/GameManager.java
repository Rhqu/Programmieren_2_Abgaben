package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.Ufo;
import thd.gameobjects.movable.UfoShot;
import thd.gameobjects.unmovable.ScorePanel;

/**
 * Manages the game objects and game logic.
 */

class GameManager {
    private final GameView gameView;
    private Ufo ufo;
    private UfoShot ufoShot;
    private ScorePanel scorePanel;

    /**
     * Creates a new GameManager with the given GameView.
     *
     * @param gameView the GameView used to display game objects.
     */

    public GameManager(GameView gameView) {
        this.gameView = gameView;
        ufo = new Ufo(gameView);
        ufoShot = new UfoShot(gameView);
        scorePanel = new ScorePanel(gameView);
    }

    void processFrame() {
        ufo.updatePosition();
        ufo.addToCanvas();
        ufoShot.addToCanvas();
        ufoShot.updatePosition();
        scorePanel.addToCanvas();
    }
}
