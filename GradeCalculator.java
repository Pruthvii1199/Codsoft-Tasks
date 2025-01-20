import java.util.Scanner;

class Grade {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Input: Number of subjects and marks in each subject
            System.out.print("Enter your number of subjects: ");
            int numberOfSubjects = scanner.nextInt();

            int[] marks = new int[numberOfSubjects];
            int totalMarks = 0;

            for (int i = 0; i < numberOfSubjects; i++) {
                System.out.print("Enter your marks for subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextInt();

                // Validating input marks
                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Invalid input! Marks should be between 0 and 100.");
                    return;
                }

                totalMarks += marks[i];
            }

            // Calculate average percentage
            double averagePercentage = (double) totalMarks / numberOfSubjects;

            // Determine grade based on average percentage
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Display results
            System.out.println("\n=== Results ===");
            System.out.println("Total Marks : " + totalMarks);
            System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
            System.out.println("Grade: " + grade);
            System.out.println("-----Conratulations-----");

            scanner.close();
        }
    }

    @Override
    public String toString() {
        return "Grade []";
    }
}
