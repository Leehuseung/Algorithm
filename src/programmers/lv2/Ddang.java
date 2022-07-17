package programmers.lv2;

/**
 * Lv2. 땅따먹기
 *
 * 22.06.29
 *
 * 22.07.12 DP 로푼다는 힌트만 참고
 */
public class Ddang {
    public static int solution(int[][] land) {
        int answer = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if(i == 0){
                    answer = Math.max(answer,land[i][j]);
                } else {
                    int max = 0;
                    for (int k = 0; k < land[i].length; k++) {
                        if(k != j){
                            max = Math.max(max,land[i-1][k]);
                        }
                    }
                    land[i][j] = land[i][j] + max;
                    answer = Math.max(answer,land[i][j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}})); //16
    }
}