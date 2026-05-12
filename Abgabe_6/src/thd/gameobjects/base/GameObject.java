package thd.gameobjects.base;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;

import java.util.Objects;

/**
 * Represents an object in the game.
 */
public abstract class GameObject {
    protected final GamePlayManager gamePlayManager;
    protected final GameView gameView;
    protected final Position position;
    protected final Position targetPosition;
    protected double speedInPixel;
    protected double rotation;
    protected double size;
    protected double width;
    protected double height;

    /**
     * Creates a new GameObject.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public GameObject(GameView gameView, GamePlayManager gamePlayManager) {
        this.gameView = gameView;
        this.gamePlayManager = gamePlayManager;
        position = new Position();
        targetPosition = new Position();
    }

    /**
     * Updates the position of the game object.
     */
    public void updatePosition() {
    }

    ;

    /**
     * Draws the game object to the canvas.
     */
    public abstract void addToCanvas();

    /**
     * Returns the current position of the game object.
     *
     * @return position of the game object.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns width of game object.
     *
     * @return Width of game object
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns height of game object.
     *
     * @return Height of game object
     */
    public double getHeight() {
        return height;
    }

    /**
     * Called when a game object is destroyed.
     *
     * @param destroyed the destroyed object.
     */
    public void gameObjectHasBeenDestroyed(GameObject destroyed) {

    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GameObject castedOther = (GameObject) other;

        return Double.compare(size, castedOther.size) == 0
                && Double.compare(width, castedOther.width) == 0
                && Double.compare(height, castedOther.height) == 0
                && Double.compare(speedInPixel, castedOther.speedInPixel) == 0
                && Double.compare(rotation, castedOther.rotation) == 0
                && Objects.equals(position, castedOther.position)
                && Objects.equals(targetPosition, castedOther.targetPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, targetPosition, size, width, height, speedInPixel, rotation);
    }

    /**
     * Updates the status of the game object.
     */
    public void updateStatus() {
    }
}