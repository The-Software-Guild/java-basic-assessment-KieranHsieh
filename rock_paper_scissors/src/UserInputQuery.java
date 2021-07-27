import javax.management.Query;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A functional interface for processing user input queries
 * @param <T>
 */
@FunctionalInterface
interface InputQuery<T> {
    /**
     * Processes a user input query using the provided scanner
     * @param scanner The scanner to use to ask for user input
     * @return The result of the query
     */
    T method(Scanner scanner);
}

/**
 * A utility class for querying for user input
 */
public class UserInputQuery {
    /**
     * Prompts the user with a provided message before asking for integer input
     * @param prompt The message to prompt the user with
     * @return The value inputted by the user if it is valid, or -1 if it was not
     */
    public static int promptGetIntegerUserInput(String prompt) {
        System.out.print(prompt);
        return queryUserInput(scanner -> {
            int result = scanner.nextInt();
            scanner.nextLine();
            return result;
        }, -1);
    }
    /**
     * Prompts the user with a provided message before asking for string input
     * @param prompt The message to prompt the user with
     * @return The value inputted by the user if it is valid, or null if it was not
     */
    public static String promptGetStringUserInput(String prompt) {
        System.out.print(prompt);
        return queryUserInput(Scanner::nextLine, null);
    }

    /**
     * A safe, generic function for querying user input and returning it if it is valid, or
     * a default value if it is not
     * @param query The function to use to query the input
     * @param defaultValue The value to return if the user's input is valid
     * @param <T> The return type of the query
     * @return The value inputted by the user, or the default value if the input was invalid
     */
    private static <T> T queryUserInput(InputQuery<T> query, T defaultValue) {
        Scanner scanner = new Scanner(System.in);
        try {
            return query.method(scanner);
        }
        catch(NoSuchElementException | IllegalStateException e) {
            System.out.println("Invalid input");
        }
        return defaultValue;
    }
}
