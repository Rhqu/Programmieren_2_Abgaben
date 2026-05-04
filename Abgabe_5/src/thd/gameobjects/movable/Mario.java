package thd.gameobjects.movable;

import thd.gameobjects.base.GameObject;
import thd.game.utilities.GameView;
import thd.game.managers.GamePlayManager;
import thd.gameobjects.base.MainCharacter;

/**
 * Represents the Mario game object that moves across the screen.
 */

public class Mario extends GameObject implements MainCharacter {
    private boolean runningRight;
    private boolean runningLeft;
    private final double groundY;
    private double verticalSpeed;
    private boolean onGround;
    private final int shotDurationInMilliseconds;

    /**
     * Creates a new Mario with the given GameView.
     *
     * @param gameView        the GameView used to display this object.
     * @param gamePlayManager the GamePlayManager to manage game play interactions.
     */

    public Mario(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        height = 0;
        width = (double) GameView.HEIGHT / 2;
        speedInPixel = RUN_SPEED;
        size = 30;
        rotation = 0;
        onGround = true;
        groundY = GROUND_Y;
        position.updateCoordinates(0, groundY);
        shotDurationInMilliseconds = SHOT_COOLDOWN_IN_MS;
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
        gameView.addImageToCanvas("mario.png", position.getX(), position.getY(), 0.4, rotation);
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
     * Mario Jumps.
     */
    public void jump() {
        if (onGround) {
            onGround = false;
            verticalSpeed = JUMP_SPEED;
        }
    }

    @Override
    public void shoot() {
        if (gameView.timer(shotDurationInMilliseconds, 0, this)) {
            gamePlayManager.spawnGameObject(new MarioShot(gameView, gamePlayManager, this));
        }
    }

    /**
     * Updates the status of Mario.
     */
    @Override
    public void updateStatus() {
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
            if (speedInPixel < 0) {
                speedInPixel = 0;
            }
        }
    }
}
