package programmers.lv2;

import java.util.Stack;

/**
 * Lv2. 택배상자
 */
public class CourierBox {
    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[order.length];
        for (int i = 0; i < order.length; i++) arr[i] = i+1;

        int k=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == order[k]){
                answer++;
                k++;
                while(!stack.isEmpty()) {
                    int ii = stack.peek();
                    if(ii == order[k]){
                        stack.pop();
                        answer++;
                        k++;
                    } else {
                        break;
                    }
                }
            } else {
                stack.add(arr[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5})); // 2
        System.out.println(solution(new int[]{5, 4, 3, 2, 1})); // 5
    }
}
