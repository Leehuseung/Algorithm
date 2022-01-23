package programmers.lv1;

public class LottoMaxAndMin {

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};

        int cnt = 0;
        for (int i = 0; i < win_nums.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if(win_nums[i] == lottos[j]){
                    cnt++;
                }
            }
        }
        answer[1] = (cnt <= 1 ? 6 : 7-cnt);

        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0){
                cnt++;
            }
        }

        answer[0] = (cnt <= 1 ? 6 : 7-cnt);

        return answer;
    }

    public static void main(String[] args) {


        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win1 = {31, 10, 45, 1, 6, 19};
        System.out.println(solution(lottos1,win1)[0] + "  " + solution(lottos1,win1)[1]);

        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win2 = {38, 19, 20, 40, 15, 25};
        System.out.println(solution(lottos2,win2)[0] + "  " + solution(lottos2,win2)[1]);

        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win3 = {20, 9, 3, 45, 4, 35};
        System.out.println(solution(lottos3,win3)[0] + "  " + solution(lottos3,win3)[1]);

        int[] lottos4 = {1, 2, 3, 4, 5, 6};
        int[] win4 = {7, 8, 9, 10, 11, 12};
        System.out.println(solution(lottos4,win4)[0] + "  " + solution(lottos4,win4)[1]);




    }
}
