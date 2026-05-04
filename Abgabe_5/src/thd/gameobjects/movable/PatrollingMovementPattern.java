package thd.gameobjects.movable;

import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

final class PatrollingMovementPattern extends MovementPattern {
    PatrollingMovementPattern() {
        pattern = new Position[]{
                new Position(700, 675),
                new Position(1000, 675)};
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
