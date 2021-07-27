/**
 * A game choice corresponding to EGameChoice.PAPER
 */
public class PaperGameChoice implements IGameChoice {
    /**
     * The PaperGameChoice will win against RockGameChoice,
     * and will tie against another PaperGameChoice. PaperGameChoice
     * will lose against all other game choice implementations
     * @param other The IGameChoice object to test against
     * @return Either WINNING_SCORE, LOSING_SCORE, or TIE_SCORE, depending on the result
     */
    @Override
    public int winsAgainst(IGameChoice other) {
        if(other.getChoiceAsEnum() == EGameChoice.ROCK) {
            return WINNING_SCORE;
        }
        else if(other.getChoiceAsEnum() == EGameChoice.PAPER) {
            return TIE_SCORE;
        }
        return LOSING_SCORE;
    }

    /**
     * Returns EGameChoice.PAPER
     * @return EGameChoice.PAPER
     */
    @Override
    public EGameChoice getChoiceAsEnum() {
        return EGameChoice.PAPER;
    }
}
