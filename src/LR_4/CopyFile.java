package LR_4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        System.out.println(copyFile("File.txt", "Copy.txt"));
        System.out.println(copyFile("someoneFile.txt", "Copy.txt"));
        System.out.println(copyFile("File.txt", "<.txt"));
    }

    public static String copyFile(String inputFile, String outputFile) {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader(inputFile);
            writer = new FileWriter(outputFile);

            int i;
            while ((i = reader.read()) != -1) {
                writer.write(i);
            }
            return "Successfully written";

        } catch (FileNotFoundException e) {
            return "Error: File not found - " + e.getMessage();
        } catch (IOException e) {
            return "Error: I/O exception - " + e.getMessage();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                return "Error: Failed to close file - " + e.getMessage();
            }
        }
    }
}