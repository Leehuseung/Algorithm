package leetcode.easy;

/**
 * 1528. Shuffle String
 */
public class SuffleString {

    public static String restoreString(String s, int[] indices) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i == indices[j]){
                    answer += s.charAt(j) + "";
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3})); // leetcode
        System.out.println(restoreString("abc", new int[]{0,1,2}));                // abc
    }
}
