package programmers.lv1;
/**
 * Lv1. 햄버거 만들기
 */

import java.util.Stack;

public class MakingHambergers {
    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            int el = ingredient[i];
            stack.add(el);
            if(stack.size() >= 4){
                int four = stack.pop();
                int three = stack.pop();
                int two = stack.pop();
                int one = stack.pop();
                if(one == 1 && two == 2 && three == 3 && four == 1){
                    answer++;
                } else {
                    stack.add(one);
                    stack.add(two);
                    stack.add(three);
                    stack.add(four);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})); //2
        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2})); //0
        System.out.println(solution(new int[]{1,2,1,2,3,1,3,1,2,3,1,2,3,1})); //3
    }
}
