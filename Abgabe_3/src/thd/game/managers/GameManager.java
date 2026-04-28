package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.FollowerBall;
import thd.gameobjects.movable.RandomBall;
import thd.gameobjects.movable.Mario;
import thd.gameobjects.movable.Star;
import thd.gameobjects.unmovable.ScorePanel;

/**
 * Manages the game objects and game logic.
 */

class GameManager {
    private final GameView gameView;
    private Mario ufo;
    private Star ufoShot;
    private ScorePanel scorePanel;
    private RandomBall randomBall;
    private FollowerBall followBall;
    /**
     * Creates a new GameManager with the given GameView.
     *
     * @param gameView the GameView used to display game objects.
     */

    public GameManager(GameView gameView) {
        this.gameView = gameView;
        ufo = new Mario(gameView);
        ufoShot = new Star(gameView);
        scorePanel = new ScorePanel(gameView);
        randomBall = new RandomBall(gameView);
        followBall = new FollowerBall(gameView, randomBall);
    }

    void processFrame() {
        ufo.updatePosition();
        ufo.addToCanvas();
        ufoShot.addToCanvas();
        ufoShot.updatePosition();
        scorePanel.addToCanvas();
        randomBall.updatePosition();
        randomBall.addToCanvas();
        followBall.addToCanvas();
        followBall.updatePosition();
    }
}
