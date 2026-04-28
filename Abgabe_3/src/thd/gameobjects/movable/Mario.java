package thd.gameobjects.movable;

import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

/**
 * Represents the Ufo game object that moves across the screen.
 */

public class Mario extends GameObject {
    private final PatroolingMovementPattern patroolingMovementPattern;

    /**
     * Creates a new Ufo with the given GameView.
     *
     * @param gameView the GameView used to display this object.
     */

    public Mario(GameView gameView) {
        super(gameView);
        height = 0;
        width = (double) GameView.HEIGHT / 2;
        patroolingMovementPattern = new PatroolingMovementPattern();
        position.updateCoordinates(new Position(patroolingMovementPattern.startPosition()));
        targetPosition.updateCoordinates(patroolingMovementPattern.nextPosition());
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
    @Override
    public void updatePosition() {
        position.moveToPosition(targetPosition, speedInPixel);
        if (position.similarTo(targetPosition)) {
            targetPosition.updateCoordinates(patroolingMovementPattern.nextPosition());
        }
    }

    /**
     * Adds this game object to the canvas of the game view.
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("mario.png", position.getX(), position.getY(), 1, rotation);
    }

}
