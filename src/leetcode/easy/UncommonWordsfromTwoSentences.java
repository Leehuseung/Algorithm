package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 884. Uncommon Words from Two Sentences
 */
public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map = new HashMap<>();
        String[] arr = (s1+" "+s2).split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
                continue;
            }
            map.put(arr[i],1);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) == 1){
                list.add(arr[i]);
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
