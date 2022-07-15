package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2325. Decode the Message
 */
public class DecodeTheMessage {
    public static String decodeMessage(String key, String message) {
        String answer = "";
        Map<Character ,Character> map = new HashMap<>();
        char a = 'a';
        char[] arr = key.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ' && !map.containsKey(arr[i])){
                map.put(arr[i],a++);
            }
        }

        char[] answerArr = message.toCharArray();
        for (int i = 0; i < answerArr.length; i++) {
            if(answerArr[i] != ' '){
                answer += map.get(answerArr[i]);
            } else {
                answer += ' ';
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv")); // this is a secret
        System.out.println(decodeMessage("eljuxhpwnyrdgtqkviszcfmabo","zwx hnfx lqantp mnoeius ycgk vcnjrdb")); // the five boxing wizards jump quickly
    }
}
