package programmers.lv1;

import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(5,new int[]{2,1,2,6,2,4,3,3})));
        System.out.println(Arrays.toString(solution(4,new int[]{4,4,4,4,4})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer,Double> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();

        //스테이지 만들기..
        for (int i = 0; i < answer.length; i++) {
            int num = i+1;
            list.add(num);
            map.put(num,getRate(num,stages));
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double d1 = map.get(o1);
                double d2 = map.get(o2);

                if(d1 - d2 > 0){
                    return -1;
                }else if (d1 - d2 < 0){
                    return 1;
                } else {
                    if(o1 - o2 > 0){
                        return 1;
                    } else{
                        return -1;
                    }
                }
            }
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }



        return answer;
    }
    public static double getRate(int stage,int[] stages){

        double notClear = 0;
        double player = 0;

        for (int i = 0; i < stages.length; i++) {
            if(stages[i] >= stage){
                player++;
            }
            if(stages[i] == stage){
                notClear++;
            }
        }

        double rate = notClear/player;

        return rate;
    }

}
