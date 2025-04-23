package filamanager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//Отвечает за чтение и запись файлов
public class FileManager {
    public List<String> readFile(String filePath) {// Логика чтения файла
        Path path = Paths.get(filePath);
        List<String> stringsReadFromText = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringsReadFromText.add(line);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
        return stringsReadFromText;
    }
    public void writeToFile(String filePath, List<String> stringsToWrite)  {// Логика чтения файла
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            for (String str : stringsToWrite) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}

