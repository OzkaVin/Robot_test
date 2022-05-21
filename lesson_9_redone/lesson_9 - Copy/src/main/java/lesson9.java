// Function ArrayList<Character> evenLettersTwoStrings(String[] strArray)
// looks for the first two strings
// in which every letter occurs even number of times.
// Function returns the collection of unique characters in this found strings.

import java.util.*;

public class lesson9 {
    public static void main(String[] args) {
        String [] strInput = new String[] {"mama", "tree", "papa", "baba", "dada"};
        System.out.println(evenLettersTwoStrings(strInput));
    }

    public static Set<Character> evenLettersTwoStrings(String[] strArray) {

        // Counter of strings for result
        int countResultStrings = 0;

        // Set for result (unique characters)
        Set<Character> resultSet = new HashSet<>();

        //counter for String Array
        int j = 0;

        while (countResultStrings < 2 && j < strArray.length) {

            // convert input String to char Array
            char[] inputChArray = strArray[j].toCharArray();

            // Map for storing unique characters
            Map<Character, Integer> charsInString = new HashMap<>();

            // Counting the occurence of every character of given string
            for (int i = 0, k = 0; i < inputChArray.length; i++) {
                if(charsInString.containsKey(inputChArray[i]))
                    continue;

                charsInString.put(inputChArray[i],1);

                for (int p = i + 1; p < inputChArray.length; p++)
                    if (inputChArray[i] == inputChArray[p])
                        charsInString.replace(inputChArray[i], charsInString.get(inputChArray[i])+1);

                k++;
            }

            // Verifying if every char occurrence is even number for string
            boolean bCharOccurenceIsEvenNumber = true;
            for(Map.Entry<Character, Integer> uniqueChar : charsInString.entrySet()){
                if (uniqueChar.getValue() % 2 != 0) {
                    bCharOccurenceIsEvenNumber = false;
                    break;
                }
            }

            // All letter occurrences for current String are even numbers
            if (bCharOccurenceIsEvenNumber) {
                for(Map.Entry<Character, Integer> uniqueChar : charsInString.entrySet())
                    resultSet.add(uniqueChar.getKey());

                countResultStrings++;
            }
            j++;
        }

        if(!resultSet.isEmpty())
            return resultSet;

        return null;
    }
}
