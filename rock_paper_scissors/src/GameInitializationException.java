/**
 * An exception thrown when an error occurs during the initialization of the game
 */
public class GameInitializationException extends Exception {
    /**
     * Constructs a new GameInitializationException with a provided message
     * @param msg The message returned by the getMessage() of Exception
     */
    public GameInitializationException(String msg) {
        super(msg);
    }
}
