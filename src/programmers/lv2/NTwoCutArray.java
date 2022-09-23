package programmers.lv2;


/**
 * Lv2. n^2 배열 자르기
 */
public class NTwoCutArray {
    public static long[] solution(int n, long left, long right) {
        long[] answer = new long[(int) (right-left+1)];
        int idx = 0;
        long startRow = left / n;
        long startCol = left % n;
        loop:
        for (; startRow < n; startRow++) {
            for (; startCol < n; startCol++) {
                if(idx >= answer.length){
                    break loop;
                }
                answer[idx++] = Math.max(startRow,startCol)+1;
            }
            startCol = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3,2,5));
    }
}
