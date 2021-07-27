import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    private static final String[] BREEDS = {
        "Chihuahua",
        "Doxen",
        "Terrier",
        "Golden Retriever",
        "Husky",
        "Common Cur"
    };
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your dog's name? ");
        String name = "Unknown";
        try {
            name = input.nextLine();
        }
        catch(IllegalStateException | NoSuchElementException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");
        System.out.println(name + " is:");

        Random rand = new Random();
        int totalPercentLeft = 100;
        // We use 1 less than the number of breeds
        int numPercents = BREEDS.length - 1;
        for(int i = 0; i < numPercents; i ++) {
            int curPercent = 0;
            if(totalPercentLeft - (numPercents - i) <= 0) {
                curPercent = 1;
            }
            else {
                // Get an random number, but make sure there is enough % left for the rest of the
                // breeds.
                curPercent = rand.nextInt(totalPercentLeft - (numPercents - i)) + 1;
            }
            totalPercentLeft -= curPercent;
            System.out.println(curPercent + "% " + BREEDS[i]);
        }
        // For the last breed, we simple take the precentage left to make up 100%
        System.out.println(totalPercentLeft + "% " + BREEDS[BREEDS.length - 1]);
        System.out.println("\nWow, that's QUITE the dog!");
    }
}
