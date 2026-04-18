package thd.gameobjects.movable;

import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

/**
 * Represents the Ufo game object that moves across the screen.
 */

public class Ufo {
    private final GameView gameView;
    private final Position position;
    private final double speedInPixel;
    private final double size;
    private double rotation;
    private final double height;
    private final double width;
    /**
     * Creates a new Ufo with the given GameView.
     *
     * @param gameView the GameView used to display this object.
     */

    public Ufo(GameView gameView) {
        this.gameView = gameView;
        height = 0;
        width = (double) GameView.HEIGHT / 2;
        this.position = new Position(height, width);
        speedInPixel = 6;
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

    public void updatePosition() {
        this.position.right(speedInPixel);
        this.rotation++;
    }

    /**
     * Adds this game object to the canvas of the game view.
     */

    public void addToCanvas() {
        gameView.addImageToCanvas("mario.png", position.getX(), position.getY(), 1, rotation);
    }

}
