package programmers;

import java.util.ArrayList;

public class NotLikeEqual {
    public static void main(String[] args) {

    }
    public int[] solution(int []arr) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(i != 0 && (arr[i-1] == arr[i])){
                continue;
            }
            list.add(arr[i]);
        }

        answer = new int[list.size()];

        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
