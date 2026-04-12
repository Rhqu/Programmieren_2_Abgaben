package thd.gameobjects.movable;

import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

/**
 * Represents the Ufo game object that moves across the screen.
 */

public class Ufo {
    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;

    /**
     * Creates a new Ufo with the given GameView.
     * @param gameView the GameView used to display this object.
     */

    public Ufo(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(0, (double) GameView.HEIGHT / 2);
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
