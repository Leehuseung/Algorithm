package programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Lv2. 영어 끝말잇기
 */
public class EnglishEndTalk {

    public static int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(i != 0 && words[i-1].charAt(words[i-1].length()-1) != word.charAt(0)){
                return new int[]{i % n + 1, i / n + 1};
            }

            if(set.contains(word)){
                return new int[]{i % n + 1, i / n + 1};
            } else {
                set.add(word);
            }
        }

        return new int[]{0,0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}))); //3,3
        System.out.println(Arrays.toString(solution(5,new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))); //0,0
        System.out.println(Arrays.toString(solution(2,new String[]{"hello", "one", "even", "never", "now", "world", "draw"}))); //1,3
    }
}
