package programmers.lv2.solution;

import java.util.PriorityQueue;

/**
 * Lv2. 광물 캐기
 *
 * 슈도 코드 참고.
 *
 * 23.06.12
 */
public class MiningForMinerals {

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < picks.length; i++) sum += picks[i];
        int p = minerals.length/5 + (minerals.length % 5 > 0 ? 1 : 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] - o2[2] > 0) return -1;
            else if(o1[2] - o2[2] < 0) return 1;
            return 0;
        });

        a :
        for (int i = 0; i < p; i++) {
            int dia = 0;
            int iron = 0;
            int stone = 0;
            for (int j = 0; j < 5; j++) {
                int t = i * 5 + j;
                if(t >= minerals.length){
                    pq.add(new int[]{dia, iron, stone});
                    break a;
                }
                if(t > sum * 5-1){
                    pq.add(new int[]{dia, iron, stone});
                    break a;
                }
                String kind = minerals[t];

                if(kind.equals("diamond")){
                    dia += 1;
                    iron += 5;
                    stone += 25;
                }else if(kind.equals("iron")){
                    dia += 1;
                    iron += 1;
                    stone += 5;
                } else {
                    dia += 1;
                    iron += 1;
                    stone += 1;
                }
            }
            pq.add(new int[]{dia, iron, stone});
        }

        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            if(picks[0] > 0){
                picks[0] -= 1;
                answer += arr[0];
                continue;
            }
            if(picks[1] > 0){
                picks[1] -= 1;
                answer += arr[1];
                continue;
            }
            if(picks[2] > 0){
                picks[2] -= 1;
                answer += arr[2];
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
    }
}
