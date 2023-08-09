package FileOperations;

import CountingOperations.TextProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileProcess {
    public static void writeToFile(File outFile, Set<String> processedWords){
        try(java.io.FileWriter fWriter = new java.io.FileWriter(outFile);
            BufferedWriter bWriter = new BufferedWriter(fWriter)){
            bWriter.write("Word Frequency (It is not case-sensitive)\n" +
                    "<------------------>");
            for(String word : processedWords){
                bWriter.newLine();
                bWriter.write(word);
            }
        }
        catch (IOException e){
            System.out.println("There is no such file");
        }
    }
    public static Set<String> readAndProcess(File file)
    {
        List<String> words = new ArrayList<String>();
        try {
            java.io.FileReader fReader = new java.io.FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);

            Set<String>  processedWords = TextProcess.cleanAndCount(words,bReader);

            bReader.close();
            return processedWords;
        }

        catch (IOException e){
            System.out.println("There is no such file");
        }

        return null;
    }
    public static File createTxtFile (String fileName) {
        File file = new File(fileName + ".txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("File cannot be created!");
            }
        }
        return file;
    }
}
