package thd.gameobjects.base;

import thd.gameobjects.base.Position;

import java.util.Random;

/**
 * Base class for movement patterns. Provides a sequence of target positions
 * circle list
 * that a {@link GameObject} can follow.
 */
public abstract class MovementPattern {

    protected Position[] pattern;
    private int currentIndex;

    protected MovementPattern() {
    }

    protected Position nextPosition() {
        if (currentIndex >= pattern.length) {
            currentIndex = 0;
        }
        return pattern[currentIndex++];
    }

    protected Position startPosition() {
        currentIndex = 0;
        return nextPosition();
    }
}
