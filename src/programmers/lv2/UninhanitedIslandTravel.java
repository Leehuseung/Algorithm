package programmers.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Lv2. 무인도 여행
 */
public class UninhanitedIslandTravel {

    public static int[] solution(String[] maps) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[][] mm = new String[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            mm[i] = maps[i].split("");
        }
        boolean[][] bb = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                int sum = 0;
                //X가 아니면 true로 변경
                if(!bb[i][j] && !mm[i][j].equals("X")){
                    sum += recursive(i,j,mm,bb,0);
                    pq.add(sum);
                }
            }
        }

        int[] answer = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) answer[i++] = pq.poll();
        return answer.length == 0 ? new int[]{-1} : answer;
    }

    private static int recursive(int i, int j, String[][] mm, boolean[][] bb, int sum) {
        if(i < 0 || j < 0 || i > mm.length-1 || j > mm[0].length-1){
            return sum;
        }
        if(bb[i][j] == false && !mm[i][j].equals("X")){
            bb[i][j] = true;
            sum += Integer.parseInt(mm[i][j]);
            sum = recursive(i+1,j,mm,bb,sum);
            sum = recursive(i-1,j,mm,bb,sum);
            sum = recursive(i,j+1,mm,bb,sum);
            sum = recursive(i,j-1,mm,bb,sum);
        } else {
            return sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{
                "X591X","X1X5X","X231X", "1XXX1"
        }))); // 1,1,27
        System.out.println(Arrays.toString(solution(new String[]{
                "XXX","XXX","XXX"
        }))); // -1
    }
}
