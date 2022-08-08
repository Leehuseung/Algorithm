package programmers.lv2.solution;

import java.util.ArrayList;

/**
 * Lv2. 하노이의 탑
 */
public class Hanoi {
    static ArrayList<int[]> list = new ArrayList<>();
    public static int[][] solution(int n) {
        recursive(n,1,3,2);

        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private static void recursive(int n, int start, int to, int via) {
        if(n == 1){
            list.add(new int[]{start,to});
        } else {
            recursive(n-1,start,via,to);
            list.add(new int[]{start,to});
            recursive(n-1,via,to,start);
        }
    }

    public static void main(String[] args) {
//        solution(2);
        solution(3);
//        System.out.println(solution(3));
    }
}
