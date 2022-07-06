package leetcode.easy;

import java.util.HashMap;

/**
 * LeetCode 1941. Check if All Characters Have Equal Number of Occurrences
 */
public class CheckifAllCharactersHaveEqualNumberofOccurrences {
    public static boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0) + 1);
        }
        Integer result = null;
        for (Character key : map.keySet()) {
            if(result == null){
                result = map.get(key);
            } else if(!result.equals(map.get(key))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc")); //true
        System.out.println(areOccurrencesEqual("aaabb"));  //false
        System.out.println(areOccurrencesEqual("mmmccmcccccmcccccmmmcmccmmccccmmmcmmcmcmcmcmmmmmmmmmcccmmcmmmcmmcmcmcmmmcmmmcmmccccmcmccmmcmccmmmcmmccccmcmmccmcmmcccmmcmmcmmcmccmmccmcmmcmmccmmccmcccmmcccmmcccccmcmmmmcmccmmmmmmcmmccmccmmcccccccccmcccmmmccmmccccmmcmcmcmcmmcmmcmcmcmccccmmcccmmmccmmcmmmcmmmcmccccmcmcccmmccmm")); // true
    }
}
