import java.util.NoSuchElementException;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        boolean shouldContinue = true;
        try {
            do {
                Scanner inputScanner = new Scanner(System.in);
                int numRounds = UserInputQuery.promptGetIntegerUserInput("How many rounds would you like to play (1 - 10)? ");
                Game rockPaperScissors = new Game(numRounds);
                rockPaperScissors.start();
                System.out.println(rockPaperScissors);
                String answer = UserInputQuery.promptGetStringUserInput("Would you like to play again (y/n)? ");
                if(answer.equals("n")) {
                    System.out.println("Thanks for playing!");
                    shouldContinue = false;
                }
                else if(!answer.equals("y")) {
                    System.out.println("Invalid choice \"" + answer + "\". The program will now exit");
                    shouldContinue = false;
                }
            }
            while(shouldContinue);

        }
        catch(GameInitializationException e) {
            System.out.println(e.getMessage());
        }
    }
}
