package programmers.lv2;

import java.util.*;

/**
 * Lv2. 모음사전
 */
public class Dictionary {
    static char[] arr = new char[]{'A','E','I','O','U'};
    static boolean[] bools;
    static Map<String,Integer> map;
    static int totalCnt = 0;

    public static int solution(String word) {
        map = new HashMap<>();
        totalCnt = 0;
        bools = new boolean[5];
        recursive("");
        return map.get(word);
    }

    private static void recursive(String s) {
        if(s.length() != 0){
            map.put(s,++totalCnt);
        }
        if(s.length() == 5){
            return;
        }
        recursive(s + arr[0]);
        recursive(s + arr[1]);
        recursive(s + arr[2]);
        recursive(s + arr[3]);
        recursive(s + arr[4]);
    }


    public static void main(String[] args) {
        System.out.println(solution("AAAAE")); //6
        System.out.println(solution("AAAE"));  //10
        System.out.println(solution("I"));     //1563
        System.out.println(solution("EIO"));   //1189
    }
}
