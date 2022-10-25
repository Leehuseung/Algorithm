package programmers.lv3;

/**
 * Lv3. 기지국 설치
 */
public class BaseStation {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = w+w+1;

        for (int i = 0; i < stations.length-1; i++) {
            int start = stations[i]+w;
            int end = stations[i+1]-w;
            int len = end-start-1;
            answer += len / cover;
            if(len%cover > 0){
                answer += 1;
            }
        }

        if(stations[0] != 0){
            int start = 1;
            int end = stations[0]-w;
            int len = end-start;

            answer += len / cover;
            if(len%cover > 0){
                answer += 1;
            }
        }

        if(stations[stations.length-1]+w < n){
            int start = stations[stations.length-1]+w;
            int end = n;
            int len = end-start;

            answer += len / cover;
            if(len%cover > 0){
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(11,new int[]{4,11},1));
        System.out.println(solution(11,new int[]{4,9},1));
    }

}
