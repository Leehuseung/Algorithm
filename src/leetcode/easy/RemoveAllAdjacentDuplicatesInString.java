package leetcode.easy;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.add(chars[i]);
                continue;
            }
            if(stack.peek() == chars[i]){
                stack.pop();
            } else {
                stack.add(chars[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static String removeDuplicates2(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates2("abbaca")); //ca
        System.out.println(removeDuplicates("abbaca")); //ca
        System.out.println(removeDuplicates("azxxzy")); //ay
    }
}
