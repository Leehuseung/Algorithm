package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

/**
 * Lv1. 둘만의 암호
 */
public class TwoPasswords {

    public static String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();
        char[] cs = new char[s.length()];
        for (int i = 0; i < skip.length(); i++) {
            set.add(skip.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < index; j++) {
                c += 1;
                if(c == '{') c = 'a';
                if(set.contains(c)) j--;
            }
            cs[i] = c;
        }
        return new String(cs);
    }
    public static void main(String[] args) {
        System.out.println(solution("aukks","wbqd",5)); // happy
    }
}
