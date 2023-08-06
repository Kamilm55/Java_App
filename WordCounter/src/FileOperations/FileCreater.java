package FileOperations;

import java.io.File;
import java.io.IOException;

public class FileCreater {
//    private String fileName;
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
