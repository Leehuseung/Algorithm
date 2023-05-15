package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

/**
 * Lv2. 롤케이크 자르기
 */
public class CutRollCake {

    public static int solution(int[] topping) {
        int answer = 0;

        int[] arr1 = new int[topping.length];
        int[] arr2 = new int[topping.length];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            set1.add(topping[i]);
            arr1[i] = set1.size();
            set2.add(topping[topping.length-i-1]);
            arr2[topping.length-i-1] = set2.size();
        }

        for (int i = 0; i < arr1.length-1; i++) {
            if(i != arr1.length-2 && arr1[i] == arr2[i+1]){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2})); // 2
        System.out.println(solution(new int[]{1, 2, 3, 1, 4})); // 0
    }
}
