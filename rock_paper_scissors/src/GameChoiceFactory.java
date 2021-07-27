/**
 * A factory construct for creating IGameChoice objects from an enum value
 */
public class GameChoiceFactory {
    /**
     * Creates an IGameChoice from a provided EGameChoice enum
     * @param choiceValue The enumerated value of the choice
     * @return The game choice as an IGameChoice object
     */
    public static IGameChoice createGameChoice(EGameChoice choiceValue) {
        switch(choiceValue) {
            case ROCK: return new RockGameChoice();
            case PAPER: return new PaperGameChoice();
            case SCISSORS: return new ScissorsGameChoice();
        }
        return null;
    }
}
