package programmers;

public class GymSuit {
    public static void main(String[] args) {
//        System.out.println(solution(5,new int[]{2,4},new int[]{1,3,5}));
//        System.out.println(solution(5,new int[]{2,4},new int[]{3}));
//        System.out.println(solution(3,new int[]{3},new int[]{1}));

//        System.out.println(solution(6,new int[]{1,2,7},new int[]{6,8,4}));
//        System.out.println(solution(6,new int[]{1,2,3,5},new int[]{}));
//        System.out.println(solution(2,new int[]{2},new int[]{1}));


//        System.out.println(solution(5,new int[]{2,4},new int[]{2,4}));

//        System.out.println(solution(6,new int[]{5,6},new int[]{4,5}));


    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        a:
        for (int i = 0; i < reserve.length; i++) {
            int num = reserve[i];

            for (int j = 0; j < lost.length; j++) {
                if (num == lost[j]) {
                    answer++;
                    lost[j] = -1;
                    reserve[i] = -1;
                    continue a;
                }
            }
        }
        b:
        for (int i = 0; i < reserve.length; i++) {
            int num = reserve[i];
            for (int j = 0; j < lost.length; j++) {
                if (num == lost[j] + 1 || num == lost[j] - 1) {
                    answer++;
                    lost[j] = -1;
                    continue b;
                }
            }
        }
        return answer;
    }
}
