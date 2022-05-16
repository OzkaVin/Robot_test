// Function ArrayList<Character> evenLettersTwoStrings(String[] strArray)
// looks for the first two strings
// in which every letter occurs even number of times.
// Function returns the collection of unique characters in this found strings.

import java.util.ArrayList;

public class lesson9 {
    public static void main(String[] args) {
        String [] strInput = new String[] {"mama", "tree", "papa", "baba", "dada"};
        ArrayList<Character> result = evenLettersTwoStrings(strInput);
        System.out.println(result);
    }

    public static ArrayList<Character> evenLettersTwoStrings(String[] strArray) {

        // Counter of strings for result
        int countResultStrings = 0;

        // String Array for result
        ArrayList<Character> resultArray = new ArrayList<>();

        //counter for String Array
        int j = 0;

        while (countResultStrings < 2 && j < strArray.length) {

            // convert input String to char Array
            char[] inputChArray = strArray[j].toCharArray();

            // Array for storing unique characters
            ArrayList<Character> uniqueChars = new ArrayList<>();
            // Array for counting unique characters
            ArrayList<Integer> uniqueCharsOccurences = new ArrayList<>();

            // Flag if the character is already handled
            boolean bAlreadyExists = false;

            // Counting the occurence os every character of given string
            for (int i = 0, k = 0; i < inputChArray.length; i++) {
                bAlreadyExists = false;

                if(uniqueChars.size() != 0) {
                    for (char c : uniqueChars) {
                        if (c == inputChArray[i])
                            bAlreadyExists = true;
                    }
                }

                if (bAlreadyExists)
                    continue;

                uniqueChars.add(Character.valueOf(inputChArray[i]));
                uniqueCharsOccurences.add(1);

                for (int p = i + 1; p < inputChArray.length; p++)
                    if (inputChArray[i] == inputChArray[p])
                        uniqueCharsOccurences.set(k, uniqueCharsOccurences.get(k)+1);

                k++;
            }

            // Verifying if every char occurrence is even number for string
            boolean bOddOccEveryLetter = true;
            for (int i : uniqueCharsOccurences) {
                if (i % 2 != 0) {
                    bOddOccEveryLetter = false;
                    break;
                }
            }

            // All letter occurrences for current String is even number
            if (bOddOccEveryLetter) {
                for (char a : uniqueChars) {
                    if(!resultArray.contains(a))
                        resultArray.add(a);
                }
                countResultStrings++;
            }
            j++;
        }

        if (resultArray.size() !=0 ){
            return resultArray;
        }
        return null;
    }
}
