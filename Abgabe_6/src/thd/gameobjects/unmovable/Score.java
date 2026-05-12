package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

import java.awt.*;

/**
 * Shows the points.
 */
public class Score extends GameObject {

    /**
     * Creates a new Scoreboard for Mario.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public Score(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
        position.updateCoordinates(60, 30);
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas("MARIO", 60, 20, 16, true, Color.WHITE, 0, "super_mario.ttf");
        gameView.addTextToCanvas(Integer.toString(gamePlayManager.getPoints()), 60, 50, 24, true, Color.WHITE, 0, "super_mario.ttf");
    }
}
