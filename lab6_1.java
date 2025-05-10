import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        System.out.println("Attempting to copy content from " + inputFile + " to " + outputFile);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Write a new line character after each line
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file '" + inputFile + "' not found.");
            System.err.println("Please make sure the file exists in the correct directory.");
            e.printStackTrace(); // Optional: print stack trace for debugging
        } catch (IOException e) {
            System.err.println("Error during file reading or writing:");
            e.printStackTrace(); // Print stack trace for debugging
        }
    }
}
