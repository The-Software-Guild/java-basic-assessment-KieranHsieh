import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age = 0;
        System.out.print("What is your age? ");
        try {
            age = input.nextInt();
        }
        catch(NoSuchElementException | IllegalStateException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        int maximumHeartRate = 220 - age;
        int minHRZone = (int) Math.round((float)maximumHeartRate * 0.5);
        int maxHRZone = (int) Math.round((float)maximumHeartRate * 0.85);
        System.out.println("Your maximum heart rate should be " + maximumHeartRate + " beats per minute");
        System.out.println("Your target HR zone is " + minHRZone + " - " + maxHRZone + " beats per minute");
    }
}
