package leetcode.easy;

/**
 * LeetCode 2315. Count Asterisks
 */
public class CountAsterisks {
    public static int countAsterisks(String s) {
        int answer = 0;
        String[] arr = s.split("\\|");
        for (int i = 0; i < arr.length; i += 2) {
            char[] chars = arr[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == '*') answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|"));  // 2
        System.out.println(countAsterisks("iamprogrammer"));  // 0
        System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"));  // 5
    }
}
