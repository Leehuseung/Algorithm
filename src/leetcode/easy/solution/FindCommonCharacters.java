package leetcode.easy.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. Find Common Characters
 *
 * 알고리즘을 너무 복잡하게 생각했다.. 다시풀어보는게 좋을듯
 *
 * 22.08.31
 */
public class FindCommonCharacters {

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++){
            int minCount = Integer.MAX_VALUE;
            for (String s : A){
                int wordCount = 0;
                for (char cur_c : s.toCharArray()) if (cur_c == c) wordCount++;
                minCount = Math.min(minCount, wordCount);
            }

            for (int i = 0; i < minCount; i++) result.add("" + c);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }
}
