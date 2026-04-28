package thd.gameobjects.movable;

import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

final class PatroolingMovementPattern extends MovementPattern {
    PatroolingMovementPattern() {
        pattern = new Position[]{
                new Position(100, 100),
                new Position(1100, 100)};
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
