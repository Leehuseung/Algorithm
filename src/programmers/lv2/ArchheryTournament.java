package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 양궁대회
 *
 * 22.08.14
 *
 * 해설참조..
 *회
 * 22.08.17
 */
public class ArchheryTournament {
    static int[] apeach;
    static int[] answer;
    static int answerScore = 0;
    public static int[] solution(int n, int[] info) {
        answer = new int[11];
        apeach = info;
        recursive(n, 0 , new int[11]);
        if(answerScore == 0){
            return new int[]{-1};
        }
        return answer;
    }

    private static void recursive(int arrow, int i, int[] lion) {
        //점수를 모두 순회했다면
        if(i > 10){
            if(arrow > 0) {
                lion[10] = arrow;
                arrow = 0;
            }
            //차를 구한다
            //Max면 answer에 lion을 대입한다.
            if(answerScore <= calLionScore(apeach,lion)){
                if(answerScore == calLionScore(apeach,lion)){
                    int idxLion = 0;
                    for (int j = 10; j >= 0; j--) {
                        if(lion[j] != 0){
                            idxLion = j;
                        }
                    }

                    int idxPch = 0;
                    for (int j = 10; j >= 0; j--) {
                        if(answer[j] != 0){
                            idxPch = j;
                        }
                    }

                    if(idxLion > idxPch){
                        return;
                    }
                }
                answerScore = calLionScore(apeach,lion);
                System.arraycopy(lion,0,answer,0,11);
            }
            return;
        } else if(arrow == 0){
            //Max면 answer에 lion을 대입한다.
            if(answerScore <= calLionScore(apeach,lion)){
                if(answerScore == calLionScore(apeach,lion)){
                    int idxLion = 0;
                    for (int j = 10; j >= 0; j--) {
                        if(lion[j] != 0){
                            idxLion = j;
                            break;
                        }
                    }

                    int idxPch = 0;
                    for (int j = 10; j >= 0; j--) {
                        if(answer[j] != 0){
                            idxPch = j;
                            break;
                        }
                    }

                    if(idxLion < idxPch){
                        lion[i] = 0;
                        return;
                    }
                }
                answerScore = calLionScore(apeach,lion);
                System.arraycopy(lion,0,answer,0,11);
                lion[i] = 0;
            }
            return;
        }

        //라이언이 이긴다.
        int num = apeach[i];  //i번쨰 과녁의 apache가 쏜 num

        //화살수가 된다면
        if(arrow >= num+1){
            lion[i] = num+1;
            recursive(arrow-num-1,i+1,lion);
            lion[i] = 0;
        }

        //어피치가 이긴다 --> 화살은 그대로,
        recursive(arrow, i+1, lion);

        //빠져나갈때는 lion을 초기화
        lion[i] = 0;
    }

    public static int calLionScore(int[] ape, int[] lion){
        int lionScore = 0;
        int apeScore = 0;
        for (int i = 0; i < ape.length; i++) {
            if(ape[i] < lion[i]){
                lionScore += 10-i;
            } else if (ape[i] != 0){
                apeScore += 10-i;
            }
        }
        return lionScore-apeScore;
    }

    static int[] res = { -1 };
    static int[] lion;
    static int max = -1000;
    public static void dfs(int[] info, int cnt, int n) {
        if(cnt == n+1) {
            int apeach_point = 0;
            int lion_point = 0;
            for(int i = 0; i <= 10; i++) {
                if(info[i] != 0 || lion[i] != 0) {
                    if(info[i] < lion[i])
                        lion_point += 10 - i;
                    else
                        apeach_point += 10 - i;
                }
            }
            if(lion_point > apeach_point) {
                if(lion_point - apeach_point >= max) {
                    res = lion.clone();
                    max = lion_point - apeach_point;
                }
            }
            return ;
        }
        for(int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
            lion[j]++;
            dfs(info, cnt + 1, n);
            lion[j]--;
        }
    }

    public static int[] solution2(int n, int[] info) {
        lion = new int[11];
        dfs(info,1,n);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution2(5,new int[]{2,1,1,1,0,0,0,0,0,0,0}))); // [0,2,2,0,1,0,0,0,0,0,0]
//        System.out.println(Arrays.toString(solution(1,new int[]{1,0,0,0,0,0,0,0,0,0,0}))); // [-1]
//        System.out.println(Arrays.toString(solution(9,new int[]{0,0,1,2,0,1,1,1,1,1,1}))); // [1,1,2,0,1,2,2,0,0,0,0]
//        System.out.println(Arrays.toString(solution(3,new int[]{0,0,1,0,0,0,0,0,0,1,0}))); //[1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0]
    }
}
