package thd.gameobjects.movable;

import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

/**
 * Represents the UfoShot game object that moves across the screen.
 */

public class UfoShot {
    private final GameView gameView;
    private final Position position;
    private final double speedInPixel;
    private final double size;
    private double rotation;
    private final double width;
    private final double height;

    /**
     * Creates a new UfoShot with the given GameView.
     *
     * @param gameView the GameView used to display this object.
     */

    public UfoShot(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(1100, 650);
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

    public void updatePosition() {
        this.position.left(speedInPixel);
    }

    /**
     * Adds this game object to the canvas of the game view.
     */

    public void addToCanvas() {
        gameView.addBlockImageToCanvas(StarBlockImages.STAR, position.getX(), position.getY(), 4, 0);
    }

}
