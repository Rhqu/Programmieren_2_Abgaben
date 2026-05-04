package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;
import thd.game.managers.GamePlayManager;

/**
 * Goomba enemy that patrols horizontally on the ground.
 */
public class Goomba extends GameObject {
    private final PatrollingMovementPattern patroolingMovementPattern;

    /**
     * Creates a new Goomba.
     *
     * @param gameView        GameView to show the game object on.
     * @param gamePlayManager GamePlayManager to manage game play interactions.
     */
    public Goomba(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        patroolingMovementPattern = new PatrollingMovementPattern();
        position.updateCoordinates(new Position(patroolingMovementPattern.startPosition()));
        targetPosition.updateCoordinates(patroolingMovementPattern.nextPosition());
        size = 30;
        rotation = 0;
        width = 150;
        height = 33;
        speedInPixel = 2.5;
    }

    @Override
    public void updatePosition() {
        position.moveToPosition(targetPosition, speedInPixel);
        if (position.similarTo(targetPosition)) {
            targetPosition.updateCoordinates(patroolingMovementPattern.nextPosition());
        }
    }

    public void updatePosition(Position position) {
        this.position.updateCoordinates(position);
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("goomba_resized.png", position.getX(), position.getY(), 2.5, rotation);
    }
}
