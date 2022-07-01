package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 */
public class UniqueMorseCodeWords {

    public static int uniqueMorseRepresentations(String[] words) {
        String[] mosreArr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>();
        HashMap<Character,String> map = new HashMap();

        Character c = 'a';
        for (int i = 0; i < mosreArr.length; i++) {
            map.put(c, mosreArr[i]);
            c++;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String morseString = "";
            char[] carr = word.toCharArray();
            for (int j = 0; j < carr.length; j++) {
                morseString += map.get(carr[j]);
            }
            set.add(morseString);
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"})); // 2
        System.out.println(uniqueMorseRepresentations(new String[]{"a"})); // 1
    }
}
