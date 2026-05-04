package thd.gameobjects.base;

/**
 * Interface for the main character of the game.
 */
public interface MainCharacter {
    static final double GROUND_Y = 660;
    static final double IMAGE_SCALE = 0.4;
    static final int SHOT_COOLDOWN_IN_MS = 300;
    static final double JUMP_SPEED = -10;
    static final double GRAVITY = 0.5;
    static final double MAX_FALL_SPEED = 10;
    static final double RUN_SPEED = 2;
    static final double MAX_RUN_SPEED = 5;
    static final double FRICTION = 0.4;

    /**
     * Shoots a projectile.
     */
    void shoot();
}
