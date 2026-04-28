package thd.gameobjects.movable;

import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

final class QuadraticMovementPattern extends MovementPattern {
    QuadraticMovementPattern() {
        super();
        pattern = new Position[]{
                new Position(100, 100),
                new Position(1100, 100),
                new Position(1100, 600),
                new Position(100, 600)};
    }

    @Override
    protected Position nextPosition() {
        return super.nextPosition();
    }

    @Override
    protected Position startPosition() {
        return super.startPosition();
    }
}

