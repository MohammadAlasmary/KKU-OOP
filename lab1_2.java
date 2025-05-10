import java.util.Scanner;
import java.util.Locale;

public class StudentApp {

    public static void main(String[] args) {

        final int MAX_NUMBER_SUBJECTS = 5;

        String studentFullName = null;
        String idNumber = null;
        int numberOfLastSemesterSubjects = 3;
        double subjectMark1 = 0.0; // Replaced with array later
        double subjectMark2 = 0.0;
        double subjectMark3 = 0.0;
        double totalMarks = 0;
        double percentage = 0;

        boolean detailsEntered = false;
        boolean marksEntered = false;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enter Student Details");
            System.out.println("2. Calculate Total Marks and Percentage");
            System.out.println("3. Display Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
                continue; // Go back to the start of the loop
            }

            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID number: ");
                    idNumber = scanner.nextLine().trim();

                    System.out.print("Enter student full name: ");
                    String rawName = scanner.nextLine().trim();
                    // Basic capitalization for title case demonstration
                    if (!rawName.isEmpty()) {
                        String[] nameParts = rawName.toLowerCase(Locale.ENGLISH).split("\\s+");
                        StringBuilder formattedName = new StringBuilder();
                        for (String part : nameParts) {
                            if (!part.isEmpty()) {
                                formattedName.append(Character.toUpperCase(part.charAt(0)));
                                formattedName.append(part.substring(1));
                                formattedName.append(" ");
                            }
                        }
                        studentFullName = formattedName.toString().trim();
                    } else {
                        studentFullName = "";
                    }

                  
                    System.out.println("Number of subjects is fixed at " + numberOfLastSemesterSubjects + ".");

                    detailsEntered = true;
                    marksEntered = false; // Reset marks state

                    if (detailsEntered) {
                        System.out.println("Student details entered.");
                    } else {
                         System.out.println("Failed to enter student details."); // Should not happen with current logic
                    }
                    break;

                case 2:
                    if (!detailsEntered) {
                        System.out.println("Please enter student details first (Option 1).");
                        break;
                    }

                    System.out.println("Enter marks for " + numberOfLastSemesterSubjects + " subjects:");
                    totalMarks = 0; 
                    boolean validMarksInput = true;

                    // Input for the three individual subject marks
                    System.out.print("Enter mark for subject 1: ");
                    if (scanner.hasNextDouble()) {
                        subjectMark1 = scanner.nextDouble();
                        if (subjectMark1 < 0 || subjectMark1 > 100) {
                            System.out.println("Invalid mark. Please enter a value between 0 and 100.");
                            validMarksInput = false;
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number for the mark.");
                        validMarksInput = false;
                        scanner.next(); // Consume invalid input
                    }

                    if (validMarksInput) { // Only proceed if the first mark was valid
                        System.out.print("Enter mark for subject 2: ");
                        if (scanner.hasNextDouble()) {
                            subjectMark2 = scanner.nextDouble();
                             if (subjectMark2 < 0 || subjectMark2 > 100) {
                                System.out.println("Invalid mark. Please enter a value between 0 and 100.");
                                validMarksInput = false;
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number for the mark.");
                            validMarksInput = false;
                            scanner.next(); // Consume invalid input
                        }
                    }

                    if (validMarksInput) { // Only proceed if the first two marks were valid
                        System.out.print("Enter mark for subject 3: ");
                        if (scanner.hasNextDouble()) {
                            subjectMark3 = scanner.nextDouble();
                             if (subjectMark3 < 0 || subjectMark3 > 100) {
                                System.out.println("Invalid mark. Please enter a value between 0 and 100.");
                                validMarksInput = false;
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number for the mark.");
                            validMarksInput = false;
                            scanner.next(); // Consume invalid input
                        }
                    }

                    scanner.nextLine(); // Consume the newline after the last nextDouble() or next()

                    if (validMarksInput) {
                         // Calculate total marks from the three variables
                        totalMarks = subjectMark1 + subjectMark2 + subjectMark3;
                         // Calculate percentage with fixed number of subjects
                        double maxPossibleMarks = numberOfLastSemesterSubjects * 100.0; // Which is 3 * 100.0 = 300.0
                        if (maxPossibleMarks > 0) {
                             percentage = (totalMarks / maxPossibleMarks) * 100.0;
                             // Round percentage to 2 decimal places
                             percentage = Math.round(percentage * 100.0) / 100.0;
                             marksEntered = true;
                             System.out.println("Total marks and percentage calculated.");
                        }
                    } else {
                        marksEntered = false; // Invalidate marks if input was invalid
                         System.out.println("Failed to enter marks.");
                    }

                    break;

                case 3:
                    if (!detailsEntered) {
                        System.out.println("Please enter student details first (Option 1).");
                        break;
                    }
                    if (!marksEntered) {
                        System.out.println("Please calculate total marks and percentage first (Option 2).");
                        break;
                    }

                    System.out.println("\n--- Student Details ---");
                    System.out.println("ID Number: " + idNumber);
                    System.out.println("Full Name: " + studentFullName);
                    System.out.println("Number of Subjects: " + numberOfLastSemesterSubjects); // Will display 3
                    // Display individual marks
                    System.out.println("Marks: " + subjectMark1 + ", " + subjectMark2 + ", " + subjectMark3);

                    System.out.printf("Total Marks: %.2f%n", totalMarks);
                    System.out.printf("Percentage: %.2f%%%n", percentage); // %% to print a literal %

                    // Pass/Fail check
                    if (percentage >= 60.0) {
                        System.out.println("Result: Pass");
                    } else {
                        System.out.println("Result: Fail");
                    }
                    System.out.println("-----------------------");

                    break;

                case 4:
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close(); // Close the scanner resource
                    return; // Exit the main method

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
