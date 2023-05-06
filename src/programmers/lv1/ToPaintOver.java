package programmers.lv1;

/**
 * Lv1. 덧칠하기
 */
public class ToPaintOver {
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] bools = new boolean[n];
        for (int i = 0; i < bools.length; i++) bools[i] = true;
        for (int i = 0; i < section.length; i++) bools[section[i]-1] = false;
        for (int i = 0; i < bools.length; i++) {
            if(!bools[i]){
                answer++;
                for (int j = i; j < i+m; j++) {
                    if(j > bools.length-1) break;
                    bools[j] = true;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(8,4, new int[]{2,3,6})); // 2
//        System.out.println(solution(5,4, new int[]{1,3})); // 1
//        System.out.println(solution(4,4, new int[]{1,2,3,4})); // 4
    }
}
