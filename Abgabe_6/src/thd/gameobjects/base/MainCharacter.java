package thd.gameobjects.base;

/**
 * Interface for the main character of the game.
 */
public interface MainCharacter {
    double GROUND_Y = 660;
    double IMAGE_SCALE = 0.4;
    int SHOT_COOLDOWN_IN_MS = 300;
    double JUMP_SPEED = -10;
    double GRAVITY = 0.5;
    double MAX_FALL_SPEED = 10;
    double RUN_SPEED = 2;
    double MAX_RUN_SPEED = 5;
    double FRICTION = 0.4;

    /**
     * Shoots.
     */
    void shoot();
}
