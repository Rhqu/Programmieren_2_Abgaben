package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

import java.util.Random;

/**
 * Manages game play interactions such as spawning and destroying game objects.
 */
public class GamePlayManager extends UserControlledGameObjectPool {
    private final GameObjectManager gameObjectManager;
    private int currentNumberOfVisibleSquares;
    private final Random random;
    protected int points;
    protected int lives;
    private static final int LIVES = 3;

    protected GamePlayManager(GameView gameView) {
        super(gameView);
        this.gameObjectManager = new GameObjectManager();
        this.random = new Random();
        lives = LIVES;
    }

    /**
     * Spawns a game object by adding it to the game object manager.
     *
     * @param gameObject the game object to spawn.
     */
    public void spawnGameObject(GameObject gameObject) {
        gameObjectManager.add(gameObject);
    }

    /**
     * Destroys a game object by removing it from the game object manager.
     *
     * @param gameObject the game object to destroy.
     */
    public void destroyGameObject(GameObject gameObject) {
        gameObjectManager.remove(gameObject);
    }

    protected void destroyAllGameObjects() {
        gameObjectManager.removeAll();
    }

    /**
     * Removes one life.
     */
    public void lifeLost() {
        lives--;
    }

    /**
     * Adds points.
     *
     * @param pointsToBeAdded points to add.
     */
    public void addPoints(int pointsToBeAdded) {
        points += pointsToBeAdded;
    }

    /**
     * Returns the points.
     *
     * @return points.
     */
    public int getPoints() {
        return points;
    }

    private void gamePlayManagement() {
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        gameObjectManager.processFrame();
        gamePlayManagement();
    }

}
