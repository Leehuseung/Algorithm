package leetcode.easy;

/**
 * 1935. Maximum Number of Words You Can Type
 */
public class MaximumNumberofWordsYouCanType {
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int answer = arr.length;
        loop:
        for (int i = 0; i < arr.length; i++) {
            char[] chars = brokenLetters.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                String s = String.valueOf(chars[j]);
                if (arr[i].contains(s)) {
                    answer--;
                    continue loop;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world","ad"));
        System.out.println(canBeTypedWords("leet code","lt"));
    }
}
