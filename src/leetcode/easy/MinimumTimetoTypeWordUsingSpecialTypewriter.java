package leetcode.easy;

/**
 * 1974. Minimum Time to Type Word Using Special Typewriter
 */
public class MinimumTimetoTypeWordUsingSpecialTypewriter {
    public static int minTimeToType(String word) {
        int answer = word.length();

        char[] chars = word.toCharArray();

        if(chars[0] != 'a'){
            char cur = 'a';
            char next = chars[0];

            answer = getAnswer(answer, cur, next);
        }

        for (int i = 0; i < chars.length-1; i++) {
            char cur = chars[i];
            char next = chars[i+1];

            answer = getAnswer(answer, cur, next);
        }

        return answer;
    }

    private static int getAnswer(int answer, char cur, char next) {
        int max = Math.max(cur,next);
        int min = Math.min(cur,next);

        int front = max - min;
        int back = (min-'a') + ('z'-max)+1;

        answer += Math.min(front,back);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToType("abc")); // 5
        System.out.println(minTimeToType("bza")); // 7
        System.out.println(minTimeToType("zjpc")); // 34
    }
}
