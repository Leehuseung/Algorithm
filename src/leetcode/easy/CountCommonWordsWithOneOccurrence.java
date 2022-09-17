package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085. Count Common Words With One Occurrence
 */
public class CountCommonWordsWithOneOccurrence {

    public static int countWords(String[] words1, String[] words2) {
        int answer = 0;

        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        for (int i = 0; i < words1.length; i++) {
            String s = words1[i];
            if(map1.containsKey(s)) {
                map1.put(s,map1.get(s)+1);
            } else {
                map1.put(s,1);
            }
        }

        for (int i = 0; i < words2.length; i++) {
            String s = words2[i];
            if(map2.containsKey(s)) {
                map2.put(s,map2.get(s)+1);
            } else {
                map2.put(s,1);
            }
        }

        for (String s : map1.keySet()) {
            if(map1.get(s) == 1 && map2.containsKey(s) && map2.get(s) == 1){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countWords(new String[]{"leetcode","is","amazing","as","is"}, new String[]{"amazing","leetcode","is"}));
    }
}
