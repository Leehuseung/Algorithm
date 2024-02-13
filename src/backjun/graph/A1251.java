package backjun.graph;

import java.util.Scanner;

/**
 * 단어 나누기
 */
public class A1251 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        String smallestWord = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        for (int i = 1; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(reverseString(word.substring(0, i)));
                sb.append(reverseString(word.substring(i, j)));
                sb.append(reverseString(word.substring(j)));
                String candidate = sb.toString();
                if (!word.equals(candidate) && candidate.compareTo(smallestWord) < 0) {
                    smallestWord = candidate;
                }
            }
        }
        System.out.println(smallestWord);
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
//  abcdefg
//->abgfedc