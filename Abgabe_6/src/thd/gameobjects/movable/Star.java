package thd.gameobjects.movable;

import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;
import thd.game.managers.GamePlayManager;

/**
 * Represents the Star game object that moves across the screen.
 */

public class Star extends GameObject {

    /**
     * Creates a new Star with the given GameView.
     *
     * @param gameView        the GameView used to display this object.
     * @param gamePlayManager the GamePlayManager to manage game play interactions.
     */

    public Star(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(new Position(1100, 680));
        speedInPixel = 2;
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
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
        this.position.left(speedInPixel);
    }

    /**
     * Adds this game object to the canvas of the game view.
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(StarBlockImages.STAR, position.getX(), position.getY(), 2, 0);
    }

}
