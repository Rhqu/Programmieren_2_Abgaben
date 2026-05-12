package thd.game.managers;

import thd.gameobjects.base.GameObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Manages all game objects, handling their addition, removal and frame updates.
 */
public class GameObjectManager extends CollisionManager {
    private final List<GameObject> gameObjects;
    private final List<GameObject> gameObjectsToBeAdded;
    private final List<GameObject> gameObjectsToBeRemoved;
    private static final int MAXIMUM_NUMBER_OF_GAME_OBJECTS = 500;

    GameObjectManager() {
        this.gameObjects = new LinkedList<>();
        this.gameObjectsToBeAdded = new LinkedList<>();
        this.gameObjectsToBeRemoved = new LinkedList<>();
    }

    void add(GameObject gameObject) {
        gameObjectsToBeAdded.add(gameObject);
    }

    void remove(GameObject gameObject) {
        gameObjectsToBeRemoved.add(gameObject);
    }

    void removeAll() {
        gameObjectsToBeAdded.clear();
        gameObjectsToBeRemoved.addAll(gameObjects);
    }

    void processFrame() {
        updateLists();
        for (GameObject gameObject : gameObjects) {
            gameObject.updateStatus();
            gameObject.updatePosition();
            gameObject.addToCanvas();
        }
        manageCollisions(true);
    }

    private void updateLists() {
        removeFromGameObjects();
        addToGameObjects();
        if (gameObjects.size() > MAXIMUM_NUMBER_OF_GAME_OBJECTS) {
            throw new TooManyGameObjectsException("To many objects have been created, this will cause a slowdown, Object Amoung: " + MAXIMUM_NUMBER_OF_GAME_OBJECTS);
        }
    }

    private void removeFromGameObjects() {
        for (GameObject currentGameObject : gameObjectsToBeRemoved) {
            gameObjects.remove(currentGameObject);
            removeFromCollisionManagement(currentGameObject);
            for (GameObject remainingGameObjects : gameObjects) {
                remainingGameObjects.gameObjectHasBeenDestroyed(currentGameObject);
            }
        }
        gameObjectsToBeRemoved.clear();
    }

    private void addToGameObjects() {
        for (GameObject currentGameObject : gameObjectsToBeAdded) {
            gameObjects.add(currentGameObject);
            addToCollisionManagement(currentGameObject);
        }
        gameObjectsToBeAdded.clear();
    }
}
