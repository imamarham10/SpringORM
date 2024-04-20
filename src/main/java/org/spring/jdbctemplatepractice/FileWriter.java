package org.spring.jdbctemplatepractice;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter {

	public static void main(String[] args) {
        // Specify the file path
        String filePath = "example.txt";

        try {
            // Create a File object (this step creates the file if it doesn't exist)
            File file = new File(filePath);

            // Create a FileWriter object
            FileWriter writer = new FileWriter(file);

            // Write content to the file
            writer.write("Hello, this is some content written to the file.\n");
            writer.write("This is another line of content.\n");

            // Close the writer
            writer.close();

            System.out.println("File created and content successfully written.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
