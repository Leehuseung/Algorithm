package leetcode.easy;

/**
 * LeetCode 1374. Generate a String With Characters That Have Odd Counts
 */
public class GenerateaStringWithCharactersThatHaveOddCounts {
    public static String generateTheString(int n) {
        String answer = "";
        String a = "a";
        String b = "b";
        if(n % 2 == 1){
            for (int i = 0; i < n; i++) {
                answer += a;
            }
        } else {
            n = n-1;
            for (int i = 0; i < n; i++) {
                answer += a;
            }
            answer += b;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(generateTheString(4)); //pppz
        System.out.println(generateTheString(2)); //xy
        System.out.println(generateTheString(7)); //holasss
    }
}
