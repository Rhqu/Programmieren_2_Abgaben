package thd.gameobjects.movable;

import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

/**
 * Represents the UfoShot game object that moves across the screen.
 */

public class Star extends GameObject {

    /**
     * Creates a new UfoShot with the given GameView.
     *
     * @param gameView the GameView used to display this object.
     */

    public Star(GameView gameView) {
        super(gameView);
        position.updateCoordinates(new Position(1100, 650));
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
        gameView.addBlockImageToCanvas(StarBlockImages.STAR, position.getX(), position.getY(), 4, 0);
    }

}
