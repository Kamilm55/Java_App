package FileOperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FileWriter
{
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

}
