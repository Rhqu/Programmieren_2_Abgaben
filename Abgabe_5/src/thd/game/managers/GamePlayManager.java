package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.gameobjects.movable.Goomba;
import thd.gameobjects.movable.Square;

import java.util.Random;

/**
 * Manages game play interactions such as spawning and destroying game objects.
 */
public class GamePlayManager extends UserControlledGameObjectPool {
    private final GameObjectManager gameObjectManager;
    private int currentNumberOfVisibleSquares;
    private final Random random;

    protected GamePlayManager(GameView gameView) {
        super(gameView);
        this.gameObjectManager = new GameObjectManager();
        this.random = new Random();
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

    private void gamePlayManagement() {
        if (currentNumberOfVisibleSquares < 5) {
            if (gameView.timer(1000, 0, this)) {
                spawnGameObject(new Square(gameView, this));
                currentNumberOfVisibleSquares++;
            }
        }
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        gameObjectManager.processFrame();
        gamePlayManagement();
    }

}
