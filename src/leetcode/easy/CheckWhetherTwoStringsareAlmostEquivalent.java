package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2068. Check Whether Two Strings are Almost Equivalent
 */
public class CheckWhetherTwoStringsareAlmostEquivalent {
    public static boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            map1.put(Character.valueOf(chars1[i]),map1.getOrDefault(chars1[i],0) + 1);
        }
        for (int i = 0; i < chars2.length; i++) {
            map2.put(Character.valueOf(chars2[i]),map2.getOrDefault(chars2[i],0) + 1);
        }

        for (Character character : map1.keySet()) {
            if(Math.abs(map1.getOrDefault(character,0) - map2.getOrDefault(character,0)) > 3){
                return false;
            }
        }

        for (Character character : map2.keySet()) {
            if(Math.abs(map1.getOrDefault(character,0) - map2.getOrDefault(character,0)) > 3){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        checkAlmostEquivalent("aaaa","bccb");
    }
}
