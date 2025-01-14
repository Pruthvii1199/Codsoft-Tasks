import java.util.Scanner;
import java.util.Random;

public class Guessgame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Fixed range: 1 to 100
        int rangeStart = 1;
        int rangeEnd = 100;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Which is created by Pruthvi.");
        System.out.println("I have chosen a number between " + rangeStart + " and " + rangeEnd + ".");
        System.out.println("Can you guess what it is?");

        // Generate random number
        int randomNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;

        int attempts = 0;
        boolean hasGuessed = false;

        // Game loop
        while (!hasGuessed) {
            System.out.print("\nEnter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            // Check the guess
            if (userGuess == randomNumber) {
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                hasGuessed = true;
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }

        System.out.println("\nThank you for playing! Goodbye!");
        scanner.close();
    }
}
