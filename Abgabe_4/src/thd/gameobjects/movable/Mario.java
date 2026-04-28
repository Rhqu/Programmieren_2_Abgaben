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
        speedInPixel = 6;
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
        position.left(speedInPixel);
    }

    /**
     * Moves Mario to the right.
     */
    public void right() {
        position.right(speedInPixel);
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
     * Jumping logic, scans for input in {@link #jump()}.
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
    }

    @Override
    public void updateStatus() {
        if (gameView.timer(5000, 0, this)) {
            this.size += 1;
        }
    }
}
