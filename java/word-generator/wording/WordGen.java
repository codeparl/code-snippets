

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a program that, given a seven-digit number, 
 * uses a PrintStream object to write 
 * to a file every possible seven-letter 
 * word combination corresponding to that number.
 * There are 2,187 (37) such combinations.
 *  Avoid phone numbers with the digits 0 and 1.
 */

public class WordGen {

    private HashMap<Integer, String> keypadMap;
    private ArrayList<String> wordsList;

    public WordGen() {
        keypadMap = new HashMap<>();
        wordsList =  new ArrayList<>();
        keypadMap.put(2, "A B C");
        keypadMap.put(3, "D E F");
        keypadMap.put(4, "G H I");

        keypadMap.put(5, "J K L");
        keypadMap.put(6, "M N O");
        keypadMap.put(7, "P R S");

        keypadMap.put(8, "T U V");
        keypadMap.put(9, "W X Y");

    }

    public void clearList(){
        if(wordsList != null)
        wordsList.clear();
    }
    public ArrayList<String> getWordList(){
        return wordsList;
    }
    public ArrayList<String> fillWordList(String digits){
        for(int i =1; i <= Math.pow(3,7); i++){
            var word =  generate(digits);
            if(!wordsList.contains(word))
            wordsList.add(word);
        }
        return wordsList; 
    }
 
    public String generate(String digits) {
        StringBuilder  sb =  new StringBuilder();
        char[] chars  =  digits.trim().toCharArray();
        SecureRandom  random  =  new SecureRandom();
         for (char c : chars) {
           var letters  =  keypadMap.get(Integer.valueOf(c+"")).split("(\s+)");
             sb.append( letters[0 + random.nextInt(letters.length)]);
     }
        return sb.toString();
    }



}
