import java.util.Random;

/**
 * An abstraction for a game of Rock Paper Scissors
 */
public class Game {
    /**
     * The minimum number of rounds allowed in a game
     */
    private static final int MINIMUM_NUMBER_OF_ROUNDS = 1;
    /**
     * The maximum number of rounds allowed in a game
     */
    private static final int MAXIMUM_NUMBER_OF_ROUNDS = 10;
    /**
     * The number of times the player has lost
     */
    private int losses;
    /**
     * THe number of times the player has won
     */
    private int wins;
    /**
     * The number of times the player has tied
     */
    private int ties;
    /**
     * The number of rounds played by the game
     */
    private int roundCount;

    /**
     * Initializes a game with a set number of rounds
     * @param numRounds The number of rounds for the game
     * @throws GameInitializationException If numRounds is outside of the range of
     * [MINIMUM_NUMBER_OF_ROUNDS, MAXIMUM_NUMBER_OF_ROUNDS], as GameInitializationException is thrown
     */
    public Game(int numRounds) throws GameInitializationException {
        if(numRounds < MINIMUM_NUMBER_OF_ROUNDS || numRounds > MAXIMUM_NUMBER_OF_ROUNDS) {
            String errMsg = String.format("Invalid number of rounds \"%d\" must be between in the range [%d, %d]",
                    numRounds, MINIMUM_NUMBER_OF_ROUNDS, MAXIMUM_NUMBER_OF_ROUNDS);
            throw new GameInitializationException(errMsg);
        }
        roundCount = numRounds;
    }

    /**
     * Starts the game of Rock Paper Scissors
     */
    public void start() {
        for(int i = 0; i < roundCount; i++) {
            System.out.println("\nChoose one of the following:");
            System.out.println("1) Rock");
            System.out.println("2) Paper");
            System.out.println("3) Scissors");
            // We subtract one here, since EGameChoice.values() is a 0 indexed array
            int choice = UserInputQuery.promptGetIntegerUserInput("What is your choice? ") - 1;
            EGameChoice[] choices = EGameChoice.values();
            try {
                // -2 Here because we subtract 1 from the input value.
                if(choice == -2) {
                    throw new GameRuntimeException();
                }
                IGameChoice gameChoice = GameChoiceFactory.createGameChoice(choices[choice]);
                // This should not occur unless the provided choice was invalid
                if(gameChoice == null) {
                    throw new GameRuntimeException();
                }
                System.out.println("You chose " + gameChoice.getChoiceAsEnum().name());
                // Choose a game choice for the computer
                Random rand = new Random();
                // A random integer in the range [1, 3]
                int compChoice = rand.nextInt(3);
                IGameChoice computeChoice = GameChoiceFactory.createGameChoice(choices[compChoice]);
                // This should not occur unless the provided choice was invalid
                if(computeChoice == null) {
                    throw new GameRuntimeException();
                }
                System.out.println("The computer chose " + computeChoice.getChoiceAsEnum().name());
                int result = gameChoice.winsAgainst(computeChoice);
                switch(result) {
                    case IGameChoice.LOSING_SCORE: processLoss(); break;
                    case IGameChoice.TIE_SCORE: processTie(); break;
                    case IGameChoice.WINNING_SCORE: processWin(); break;
                }
            }
            // If we enter invalid input, we count this round as a loss
            catch(ArrayIndexOutOfBoundsException | GameRuntimeException e) {
                String errMessage = String.format("Invalid choice %d, your choice must be one of [1, 2, 3]. You have lost this round",
                        choice+1);
                System.out.println(errMessage);
                losses++;
            }
        }
    }

    /**
     * Increments the Game's internal player win counter and displays a message
     */
    private void processWin() {
        wins++;
        System.out.println("You Won!");
    }

    /**
     * Increments the Game's internal player loss counter and displays a message
     */
    private void processLoss() {
        losses++;
        System.out.println("You lost");
    }
    /**
     * Increments the Game's internal player tie counter and displays a message
     */
    private void processTie() {
        ties++;
        System.out.println("You tied!");
    }

    /**
     * Get the number of player wins
     * @return The number of player wins
     */
    public int getWinCount() {
        return wins;
    }
    /**
     * Get the number of player losses
     * @return The number of player losses
     */
    public int getLossCount() {
        return losses;
    }
    /**
     * Get the number of player ties
     * @return The number of player ties
     */
    public int getTieCount() {
        return ties;
    }

    /**
     * Converts the current game STATE into a string, displaying wins, losses, ties, and the overall result
     * @return The game state as a string
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Results:\n");
        builder.append("\tWins: ").append(wins).append("\n");
        builder.append("\tLosses: ").append(losses).append("\n");
        builder.append("\tTies: ").append(ties).append("\n");
        if(wins > losses) {
            builder.append("You won!");
        }
        else if(wins < losses) {
            builder.append("You lost");
        }
        else {
            builder.append("You tied it up");
        }
        return builder.toString();
    }
}
