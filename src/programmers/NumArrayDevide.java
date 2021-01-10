package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class NumArrayDevide {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5,9,7,10},5)));
        System.out.println(Arrays.toString(solution(new int[]{2,36,1,3},1)));
        System.out.println(Arrays.toString(solution(new int[]{3,2,6},10)));
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%divisor == 0){
                list.add(arr[i]);
            }
        }

        if(list.size() == 0){
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()];

            for(int i = 0 ; i < list.size(); i++){
                answer[i] = list.get(i);
            }

            Arrays.sort(answer);
        }

        return answer;
    }

}
