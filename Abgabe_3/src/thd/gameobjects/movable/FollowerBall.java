package thd.gameobjects.movable;

import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

import java.awt.*;

/**
 * Represents the FollowBall game object that moves across the screen.
 */

public class FollowerBall extends GameObject {
    private final RandomBall followMe;

    /**
     * Creates a new FollowBall with the given GameView.
     *
     * @param gameView the GameView used to display this object.
     * @param followMe the Ball that the FollowerBall follows as a reference.
     */

    public FollowerBall(GameView gameView, RandomBall followMe) {
        super(gameView);
        position.updateCoordinates(new Position(0, 0));
        this.followMe = followMe;
        targetPosition.updateCoordinates(followMe.getPosition());
        speedInPixel = 3;
        size = 55;
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
        targetPosition.updateCoordinates(followMe.getPosition());
        position.moveToPosition(targetPosition, speedInPixel);
    }

    /**
     * Adds this game object to the canvas of the game view.
     */
    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.getX(), position.getY(), 55, 55, 1, true, Color.GREEN);
    }

}

