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
            // Открытие файлов
            reader = new FileReader(inputFile);
            writer = new FileWriter(outputFile);

            int i;
            // Чтение файлов посимвольно и запись в новый файл
            while ((i = reader.read()) != -1) {
                writer.write(i);
            }
            return "Successfully written";

        } catch (FileNotFoundException e) {
            // файл не найден
            return "Error: File not found - " + e.getMessage();
        } catch (IOException e) {
            //ошибка ввода-вывода
            return "Error: I/O exception - " + e.getMessage();
        } finally { // закрытие файла в любом случае
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