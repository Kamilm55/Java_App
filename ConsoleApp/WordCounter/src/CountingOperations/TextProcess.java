package CountingOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TextProcess {
    public static Set<String> cleanAndCount( List<String> words, BufferedReader bReader)throws IOException{
        cleanText(words,bReader);
        return countWords(words);
    }

    public static void cleanText ( List<String> words, BufferedReader bReader) throws IOException {
        String line =  bReader.readLine(); // read and process
        while (line != null){
            String[] unusedSigns = { ".", ",", "/", "'", ";", ":", "-", "+", "*", "?", "!", "@", "#", "$", "%", "^", "&", "(", ")", "[", "]", "{", "}", "<", ">", "=", "|", "~", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
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

    }
    public static Set<String> countWords(List<String> words) {
        Set<String> processedWords = new LinkedHashSet<String>();// for unique print of words // FIFO
        // nested loop for checking equality
        for (int i=0;i<words.size();i++){
            int count = 0;


            for(int j=0;j<words.size();j++){ // == check address value .equals check actual value of string

                if(words.get(i).toUpperCase().equals(words.get(j).toUpperCase())){// ignoring case-sensitivity
                    count++;
                }
            }
            processedWords.add(words.get(i).toLowerCase() + ": " + count);
        }
        return processedWords;
    }
}
