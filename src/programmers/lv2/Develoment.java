package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class Develoment {
    public static void main(String[] args) {
        solution(new int[]{93,33,50},new int[]{1,30,5});
        solution(new int[]{95,90,99,99,80,99}, new int[]{1,1,1,1,1,1});
//        solution(new int[]{55,10,69,89,81,99}, new int[]{10,1,5,2,1,6});
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int[] days = new int[progresses.length];

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int sum = 0;
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                sum++;
            }
            days[i] = sum;
        }

        System.out.println(Arrays.toString(days));

        int sum = 0;
        int compareInt = days[0];

        for (int i = 0; i < days.length; i++) {
            sum++;
            if(i != days.length-1){
                if(compareInt < days[i+1]){
                    compareInt = days[i+1];
                    list.add(sum);
                    sum = 0;
                }
            } else {
                list.add(sum);
            }
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
