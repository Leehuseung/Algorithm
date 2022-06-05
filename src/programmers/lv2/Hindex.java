package programmers.lv2;

import java.util.Arrays;
import java.util.Collections;

/**
 * Lv2. H-index
 */
public class Hindex {

        public static int solution(int[] citations) {
            int answer = -1;

            Integer[] arr = new Integer[citations.length];
            for (int i = 0; i < citations.length; i++) {
                arr[i] = citations[i];
            }

            Arrays.sort(arr, Collections.reverseOrder());

            for (int i = 0; i < arr.length; i++) {
                if(i >= arr[i]){
                    answer = i;
                    break;
                }
            }

            if(answer == -1){
                answer = arr.length;
            }

            return answer;
        }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{3,0,6,1,5}));  // 3
        System.out.println(solution(new int[]{10,8,5,4,3}));  // 4
        System.out.println(solution(new int[]{25,8,5,3,3}));  // 3
        System.out.println(solution(new int[]{10,10,10,10,10}));  // 5
    }
}
