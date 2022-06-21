package leetcode.easy;

/**
 * 1614. Maximum Nesting Depth of the Parentheses
 */
public class MaximumNestingDepthoftheParentheses {

    public static int maxDepth(String s) {
        int answer = 0;
        int max = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '('){
                answer++;
                if(answer > max){
                    max = answer;
                }
            } else if(arr[i] == ')') {
                answer--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1")); // 3
    }
}
