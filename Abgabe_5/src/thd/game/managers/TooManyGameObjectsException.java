package thd.game.managers;

/**
 * Exception thrown when the number of game objects exceeds the allowed maximum.
 */
public class TooManyGameObjectsException extends RuntimeException {
    TooManyGameObjectsException(String message, int objectAmount) {
        super(message + objectAmount);
    }
}
