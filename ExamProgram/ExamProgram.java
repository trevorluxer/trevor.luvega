import java.util.Scanner;

public class ExamSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Mock results for demonstration purposes
        int[] courseworkResults = {85, 75, 90, 70, 80}; // Ass1, Ass2, Ass3, Cat1, Cat2
        int finalExamResult = 80;

        do {
            // Display menu
            System.out.println("Exam System Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults(courseworkResults);
                    break;
                case 2:
                    viewExamResults(courseworkResults, finalExamResult);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 3);
    }

    // Function to view coursework results
    public static void viewCourseworkResults(int[] courseworkResults) {
        System.out.println("Coursework Results:");
        for (int i = 0; i < courseworkResults.length; i++) {
            System.out.println("Assessment " + (i + 1) + ": " + courseworkResults[i] + "%");
        }
    }

    // Function to view exam results
    public static void viewExamResults(int[] courseworkResults, int finalExamResult) {
        int courseworkScore = 0;
        for (int i = 0; i < courseworkResults.length; i++) {
            courseworkScore += courseworkResults[i];
        }
        courseworkScore = courseworkScore / courseworkResults.length;

        int totalScore = (courseworkScore / 2) + (finalExamResult / 2);

        System.out.println("Final Exam Result: " + finalExamResult + "%");
        System.out.println("Coursework Score: " + (courseworkScore / 2) + "%");
        System.out.println("Total Score: " + totalScore + "%");

        if (hasCompletedTwoThirds(courseworkResults)) {
            System.out.println("The student has completed 2/3 of the coursework.");
        } else {
            System.out.println("The student has NOT completed 2/3 of the coursework and is required to repeat.");
        }
    }

    // Function to count the number of coursework assessments
    public static int countCourseworkAssessments(int[] courseworkResults) {
        return courseworkResults.length;
    }

    // Function to determine if the student has completed 2/3 of the coursework
    public static boolean hasCompletedTwoThirds(int[] courseworkResults) {
        int count = countCourseworkAssessments(courseworkResults);
        return count >= 3;
    }
}
