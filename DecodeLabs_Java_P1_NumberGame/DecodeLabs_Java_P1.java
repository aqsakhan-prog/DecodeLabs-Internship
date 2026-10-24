import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("=================================");
        System.out.println("        NUMBER GUESSING GAME");
        System.out.println("=================================");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess the number!");

        while (guess != secretNumber) {

            System.out.print("\nEnter your guess: ");

            try {
                guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Invalid range. Please enter a number between 1 and 100.");
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("\nCongratulations! You guessed the correct number!");
                    System.out.println("The number was: " + secretNumber);
                    System.out.println("Number of attempts: " + attempts);
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next();
            }
        }

        System.out.println("\n=================================");
        System.out.println("          GAME COMPLETE");
        System.out.println("=================================");

        scanner.close();
    }
}