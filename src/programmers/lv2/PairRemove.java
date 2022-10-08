package programmers.lv2;

import java.util.Stack;

/**
 * Lv2. 짝지어 제거하기
 */
public class PairRemove {

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().equals(c)){
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa")); // 1
        System.out.println(solution("cdcd")); // 0

    }
}
