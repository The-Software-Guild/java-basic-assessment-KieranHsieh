/**
 * A game choice corresponding to EGameChoice.SCISSORS
 */
public class ScissorsGameChoice implements  IGameChoice {
    /**
     * The RockGameChoice will win against PaperGameChoice,
     * and will tie against another ScissorsGameChoice. ScissorsGameChoice
     * will lose against all other game choice implementations
     * @param other The IGameChoice object to test against
     * @return Either WINNING_SCORE, LOSING_SCORE, or TIE_SCORE, depending on the result
     */
    @Override
    public int winsAgainst(IGameChoice other) {
        if(other.getChoiceAsEnum() == EGameChoice.PAPER) {
            return WINNING_SCORE;
        }
        else if(other.getChoiceAsEnum() == EGameChoice.SCISSORS) {
            return TIE_SCORE;
        }
        return LOSING_SCORE;
    }
    /**
     * Returns EGameChoice.SCISSORS
     * @return EGameChoice.SCISSORS
     */
    @Override
    public EGameChoice getChoiceAsEnum() {
        return EGameChoice.SCISSORS;
    }
}
