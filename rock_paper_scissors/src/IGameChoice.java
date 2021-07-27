/**
 * An interface for different choices in a Game
 */
public interface IGameChoice {
    /**
     * The value returned by WinsAgainst() when the calling IGameChoice wins against
     * the IGameChoice provided in the parameters
     */
    int WINNING_SCORE = 1;
    /**
     * The value returned by WinsAgainst() when the calling IGameChoice loses against
     * the IGameChoice provided in the parameters
     */
    int LOSING_SCORE = -1;
    /**
     * The value returned by WinsAgainst() when the calling IGameChoice ties against
     * the IGameChoice provided in the parameters
     */
    int TIE_SCORE = 0;

    /**
     * Test if the calling IGameChoice object wins, loses, or ties against another IGameChoice object
     * @param other The IGameChoice object to test against
     * @return Either WINNING_SCORE, LOSING_SCORE, or TIE_SCORE, depending on the result.
     */
    int winsAgainst(IGameChoice other);

    /**
     * Retrieves the enum used to represent an implementation of the IGameChoice interface
     * @return The enum used to represent the implementing IGameChoice class
     */
    EGameChoice getChoiceAsEnum();
}
