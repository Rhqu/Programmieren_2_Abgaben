package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.managers.GamePlayManager;
import thd.gameobjects.unmovable.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Goomba enemy that patrols horizontally on the ground.
 */
public class Goomba extends CollidingGameObject {
    private final PatrollingMovementPattern patroolingMovementPattern;
    private final List<CollidingGameObject> collidingGameObjectsForPathDecision;
    private boolean movingLeft;

    /**
     * Creates a new Goomba.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public Goomba(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        this.collidingGameObjectsForPathDecision = new ArrayList<>();
        patroolingMovementPattern = new PatrollingMovementPattern();
        position.updateCoordinates(new Position(patroolingMovementPattern.startPosition()));
        targetPosition.updateCoordinates(patroolingMovementPattern.nextPosition());
        size = 30;
        rotation = 0;
        width = 40;
        height = 40;
        speedInPixel = 2;
        hitBoxOffsets(3, 4, -6, -8);
    }


    @Override
    public void updatePosition() {
        if (movingLeft) {
            left();
        } else {
            right();
        }
    }

    private void right() {
        position.right(speedInPixel);
        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                movingLeft = true;
                break;
            }
        }
    }

    private void left() {
        position.left(speedInPixel);
        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                movingLeft = false;
                break;
            }
        }
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof Mario) {
            double yCoordinateOfBottomMario = other.getPosition().getY() + other.getHeight();
            double yCoordinateOfTopGoomba = position.getY();
            if (yCoordinateOfBottomMario < yCoordinateOfTopGoomba + height / 2.0) {
                gamePlayManager.destroyGameObject(this);
                gamePlayManager.addPoints(100);
                ((Mario) other).throwMarioUp();
            } else {
                gamePlayManager.lifeLost();
            }
        }
    }

    /**
     * Adds a game object for path decisions.
     *
     * @param collidingGameObject object to add.
     */
    public void addCollidingGameObjectForPathDecision(CollidingGameObject collidingGameObject) {
        collidingGameObjectsForPathDecision.add(collidingGameObject);
    }

    @Override
    public void gameObjectHasBeenDestroyed(GameObject destroyed) {
        collidingGameObjectsForPathDecision.remove(destroyed);
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("goomba_resized.png", position.getX(), position.getY(), 2.5, rotation);
    }
}
