package FileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FileReader
{
    public static Set<String> countWords(File file)
    {
        List<String> words = new ArrayList<String>();
        Set<String> processedWords = new LinkedHashSet<String>();// for unique print of words // FIFO
        try {
            java.io.FileReader fReader = new java.io.FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);
            String line =  bReader.readLine();

            while (line != null){
                String[] unusedSigns = {".",",","/","'", ";",":","/","-","+","*"};
                String  cleanedLine = line;
                for (String sign : unusedSigns) {
                    cleanedLine = cleanedLine.replaceAll("\\Q" + sign + "\\E", ""); // \\Q and \\E to escape special characters
                }
//                cleanedLine = cleanedLine.trim();// remove all "" // it does not work

                String[] wordsArr = cleanedLine.split(" ");
                for(String word : wordsArr)
                    words.add(word);
                words.remove("");// remove all ""
                line = bReader.readLine();
            }


            // nested loop for checking equality
            for (int i=0;i<words.size();i++){
                int count = 0;


                for(int j=0;j<words.size();j++){ // == check address value .equals check actual value of string

                    if(words.get(i).toUpperCase().equals(words.get(j).toUpperCase())){// ignoring case-sensitivity
                        count++;
                    }
                }
//                System.out.println(words.get(i) + ": " + count);

                processedWords.add(words.get(i).toLowerCase() + ": " + count);
            }

            bReader.close();
        }

        catch (IOException e){
            System.out.println("There is no such file");
        }

        return processedWords;
    }
}
