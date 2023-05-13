 package programmers.lv2;

import java.util.*;

 /**
 * Lv2. 연속된 부분 수열의 합
 */
public class SumOfConsecutiveSubsequences {

    public static int[] solution(int[] sequence, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int an = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            if(sum == k && len > queue.size()) {
                len = queue.size();
                an = i;
            }
            while(!queue.isEmpty() && sum > k){ // 런타임 오류로 queue.isEmpty 조건 추가.
                sum -= queue.poll();
                if(sum == k && len > queue.size()){
                    len = queue.size();
                    an = i;
                }
            }
            queue.add(sequence[i]);
        }
        return new int[] {an-len, an};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5}, 7))); // 2,3
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5))); // 6,6
        System.out.println(Arrays.toString(solution(new int[]{100, 1, 1, 2, 3, 4, 5}, 5))); // 런타임 오류로 queue.isEmpty 조건 추가.
    }
}

//1차 시간 초과
//public static int[] solution(int[] sequence, int k) {
//    int min = 0;
//    int max = Integer.MAX_VALUE;
//    for (int i = 0; i < sequence.length; i++) {
//        int sum = 0;
//        for (int j = i; j < sequence.length; j++) {
//            sum += sequence[j];
//            if(sum > k){
//                break;
//            } else if(sum == k && max - min > j - i){
//                max = j;
//                min = i;
//            }
//        }
//    }
//    return new int[] {min, max};
//}