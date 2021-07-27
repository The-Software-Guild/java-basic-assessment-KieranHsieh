/**
 * A game choice corresponding to EGameChoice.ROCK
 */
public class RockGameChoice implements IGameChoice {
    /**
     * The RockGameChoice will win against ScissorsGameChoice,
     * and will tie against another RockGameChoice. RockGameChoice
     * will lose against all other game choice implementations
     * @param other The IGameChoice object to test against
     * @return Either WINNING_SCORE, LOSING_SCORE, or TIE_SCORE, depending on the result
     */
    @Override
    public int winsAgainst(IGameChoice other) {
        if(other.getChoiceAsEnum() == EGameChoice.SCISSORS) {
            return WINNING_SCORE;
        }
        else if(other.getChoiceAsEnum() == EGameChoice.ROCK) {
            return TIE_SCORE;
        }
        return LOSING_SCORE;
    }
    /**
     * Returns EGameChoice.ROCK
     * @return EGameChoice.ROCK
     */
    @Override
    public EGameChoice getChoiceAsEnum() {
        return EGameChoice.ROCK;
    }
}
