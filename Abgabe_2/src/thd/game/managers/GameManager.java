package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.Ufo;
import thd.gameobjects.movable.UfoShot;
import thd.gameobjects.unmovable.ScorePanel;

public class GameManager {
    private GameView gameView;
    private Ufo ufo;
    private UfoShot ufoShot;
    private ScorePanel scorePanel;

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
