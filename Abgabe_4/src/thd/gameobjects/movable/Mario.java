package thd.gameobjects.movable;

import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.utilities.GameView;

import java.awt.*;

/**
 * Represents the Mario game object that moves across the screen.
 */

public class Mario extends GameObject {
    private static final double JUMP_SPEED = -10;
    private static final double GRAVITY = 0.5;
    private static final double MAX_FALL_SPEED = 10;
    private static final double RUN_SPEED = 2;
    private static final double MAX_RUN_SPEED = 5;
    private static final double FRICTION = 0.4;
    private boolean runningRight;
    private boolean runningLeft;
    private final double groundY;
    private double verticalSpeed;
    private boolean onGround;
    private boolean shotInProgress;

    /**
     * Creates a new Mario with the given GameView.
     *
     * @param gameView the GameView used to display this object.
     */

    public Mario(GameView gameView) {
        super(gameView);
        height = 0;
        width = (double) GameView.HEIGHT / 2;
        speedInPixel = RUN_SPEED;
        size = 30;
        rotation = 0;
        shotInProgress = false;
        onGround = true;
        groundY = 660;
        position.updateCoordinates(0, groundY);
    }

    @Override
    public String toString() {
        return "Mario: " + position;
    }

    /**
     * Adds this game object to the canvas of the game view.
     */
    @Override
    public void addToCanvas() {
        if (shotInProgress) {
            gameView.addTextToCanvas("X", position.getX(), position.getY(), 47, true, Color.WHITE, 0, "droidsansmono.ttf");
            shotInProgress = false;
        } else {
            gameView.addImageToCanvas("mario.png", position.getX(), position.getY(), 0.4, rotation);
        }
    }

    /**
     * Moves Mario to the left.
     */
    public void left() {
        runningLeft = true;
    }

    /**
     * Moves Mario to the right.
     */
    public void right() {
        runningRight = true;
    }

    /**
     * Triggers a shot from Mario.
     */
    public void shoot() {
        shotInProgress = true;
    }

    /**
     * Mario Jumps.
     */
    public void jump() {
        if (onGround) {
            onGround = false;
            verticalSpeed = JUMP_SPEED;
        }
    }

    /**
     * Movement logic, scans for input in {@link #jump()} and in
     * {@link #right()} and {@link #left()} Uses acceleration and deceleration with
     * parameters defined as constants.
     */
    @Override
    public void updatePosition() {
        if (!onGround) {
            verticalSpeed += GRAVITY;
            if (verticalSpeed > MAX_FALL_SPEED) {
                verticalSpeed = MAX_FALL_SPEED;
            }
            position.down(verticalSpeed);
            if (position.getY() >= groundY) {
                position.updateCoordinates(position.getX(), groundY);
                onGround = true;
                verticalSpeed = 0;
            }
        }

        if (runningRight) {
            speedInPixel += FRICTION;
            if (speedInPixel > MAX_RUN_SPEED) {
                speedInPixel = MAX_RUN_SPEED;
            }
            position.right(speedInPixel);
            runningRight = false;
        } else if (runningLeft) {
            speedInPixel += FRICTION;
            if (speedInPixel > MAX_RUN_SPEED) {
                speedInPixel = MAX_RUN_SPEED;
            }
            position.left(speedInPixel);
            runningLeft = false;
        } else {
            speedInPixel -= FRICTION;
            if (speedInPixel < 0){
                speedInPixel = 0;
            }
        }
    }

    @Override
    public void updateStatus() {
        if (gameView.timer(5000, 0, this)) {
            this.size += 1;
        }
    }
}
