package programmers.lv1;

import java.util.Arrays;

public class RemoveMinNum {
    public static void main(String[] args) {
        solution(new int[]{4,3,2,1});
    }

    public static int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        } else {
            int[] answer = {};
            int min = arr[0];
            int minIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] < min){
                    min = arr[i];
                    minIndex = i;
                }
            }

            answer = new int[arr.length-1];
            int in = 0 ;
            for (int i = 0; i < arr.length; i++) {
                if(i == minIndex){
                    continue;
                }
                answer[in++] = arr[i];
            }
            return answer;
        }
    }
}
