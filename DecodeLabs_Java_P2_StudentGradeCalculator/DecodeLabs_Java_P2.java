
import java.util.Scanner;

public class DecodeLabs_Java_P2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfSubjects = 0;

        System.out.println("====================================");
        System.out.println("       STUDENT GRADE CALCULATOR");
        System.out.println("====================================");

        // Get a valid number of subjects.
        while (numberOfSubjects <= 0) {
            System.out.print("Enter the number of subjects: ");

            if (scanner.hasNextInt()) {
                numberOfSubjects = scanner.nextInt();

                if (numberOfSubjects <= 0) {
                    System.out.println(
                        "Please enter at least one subject."
                    );
                }
            } else {
                System.out.println(
                    "Invalid input. Enter a whole number."
                );
                scanner.next();
            }
        }

        int totalMarks = 0;

        // Read and validate marks for each subject.
        for (int i = 1; i <= numberOfSubjects; i++) {
            int marks;

            while (true) {
                System.out.print(
                    "Enter marks for subject " + i + " (0-100): "
                );

                if (scanner.hasNextInt()) {
                    marks = scanner.nextInt();

                    if (marks >= 0 && marks <= 100) {
                        break;
                    }

                    System.out.println(
                        "Marks must be between 0 and 100."
                    );
                } else {
                    System.out.println(
                        "Invalid input. Enter whole-number marks."
                    );
                    scanner.next();
                }
            }

            totalMarks += marks;
        }

        // Calculate total and average percentage.
        double maximumMarks = numberOfSubjects * 100.0;
        double averagePercentage = totalMarks / maximumMarks * 100.0;

        // Assign a grade based on the average.
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display the final results.
        System.out.println("\n====================================");
        System.out.println("           FINAL RESULTS");
        System.out.println("====================================");
        System.out.println("Number of subjects: " + numberOfSubjects);
        System.out.println("Total marks: " + totalMarks
                + " / " + (numberOfSubjects * 100));
        System.out.printf("Average percentage: %.2f%%%n",
                averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("====================================");

        scanner.close();
    }
}
