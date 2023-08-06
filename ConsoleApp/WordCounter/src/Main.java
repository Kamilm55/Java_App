import FileOperations.FileCreater;
import FileOperations.FileReader;
import FileOperations.FileWriter;
import InputOperations.InputUser;

import java.io.File;
import java.util.Set;

//1.ask user , name of the file , if it does exist continue whether create one
//2.Create a file name +  .txt
//3.Say instructions
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome the Word Counter App!");
        System.out.println("<---------------------->");
        System.out.println("(Note:filename must be created before!!!)");
        System.out.println("Enter the name of the file that you want to create:");
//        System.out.println("If it is not created before ....");
        String fileName = InputUser.enterFileName();
        File createdFile = FileCreater.createTxtFile(fileName);
        System.out.println("Enter into " + createdFile + " and add/modify text");

        System.out.println("After modifying text , write 1 to continue process:");
        if(InputUser.enterNumInput() != 1){
            System.out.println("Process end...");
            System.exit(0);
        }

        Set<String> processedWords = FileReader.countWords(createdFile);

        System.out.println("(Note:filename must be created before!!!)");
        System.out.println("Enter the name of the file that you want to write the output into:");
        String outputFileName = InputUser.enterFileName();
        File outputFile = FileCreater.createTxtFile(outputFileName);
        FileWriter.writeToFile(outputFile,processedWords);

        System.out.println("You can look " + outputFile + " for the result");

    }
}