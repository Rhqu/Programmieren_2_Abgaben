package thd.gameobjects.unmovable;

import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

import java.awt.*;

/**
 * Represents the score panel that displays the current score.
 */

public class ScorePanel extends GameObject {

    /**
     * Creates a new ScorePanel with the given GameView.
     *
     * @param gameView the GameView used to display this object.
     */

    public ScorePanel(GameView gameView) {
        super(gameView);
        width = 150;
        height = 33;
        position.updateCoordinates(new Position(GameView.WIDTH - width, 0));
        size = 30;
        rotation = 0;
    }

    @Override
    public String toString() {
        return "Ufo: " + position;
    }

    /**
     * Updates the position of this game object.
     */
    @Override
    public void updatePosition() {
        this.position.right();
        this.rotation++;
    }

    /**
     * Adds this game object to the canvas of the game view.
     */
    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas("1500", position.getX(), position.getY(),
                size, true, Color.white, 0);
    }

}
