package thd.gameobjects.movable;

import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

import java.awt.*;

/**
 * Represents the RandomBall game object that moves across the screen.
 */

public class RandomBall extends GameObject {
    private final RandomMovementPattern randomMovementPattern;
    private final int startTime;
    private final QuadraticMovementPattern quadraticMovementPattern;

    /**
     * Creates a new RandomBall with the given GameView.
     *
     * @param gameView the GameView used to display this object.
     */

    public RandomBall(GameView gameView) {
        super(gameView);
        randomMovementPattern = new RandomMovementPattern();
        position.updateCoordinates(randomMovementPattern.startPosition());
        quadraticMovementPattern = new QuadraticMovementPattern();
        targetPosition.updateCoordinates(quadraticMovementPattern.nextPosition());
        startTime = gameView.gameTimeInMilliseconds();
        speedInPixel = 4;
        size = 50;
        rotation = 0;
        width = 150;
        height = 33;
    }

    @Override
    public String toString() {
        return "Random Ball: " + position;
    }

    /**
     * Updates the position of this game object.
     */
    @Override
    public void updatePosition() {
        if (gameView.timer(1000, 4000, this)) {
            position.moveToPosition(targetPosition, speedInPixel);
        }
        if (position.similarTo(targetPosition)) {
            targetPosition.updateCoordinates(quadraticMovementPattern.nextPosition());
        }
        if (gameView.timer(3000, 0, this)) {
            speedInPixel++;
        }
    }

    /**
     * Adds this game object to the canvas of the game view.
     */
    @Override
    public void addToCanvas() {
        if (gameView.gameTimeInMilliseconds() - startTime >= 5000) {
            gameView.addOvalToCanvas(position.getX(), position.getY(), 50, 50, 1, true, Color.RED);
        } else {
            gameView.addOvalToCanvas(position.getX(), position.getY(), 50, 50, 1, true, Color.YELLOW);
        }
        gameView.addOvalToCanvas(targetPosition.getX(), targetPosition.getY(), 50, 50, 2, false, Color.WHITE);
    }


}
