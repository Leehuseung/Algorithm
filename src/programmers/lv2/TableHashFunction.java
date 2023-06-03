package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 테이블 해시 함수
 */
public class TableHashFunction {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col-1] == o2[col-1]){
                return o2[0] - o1[0];
            }
            return o1[col-1] - o2[col-1];
        });

        for (int i = row_begin-1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                int k = data[i][j];
                sum += k % (i+1);
            }
            answer = answer ^ sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {2,2,6},{1,5,10},{4,2,9},{3,8,3}
        },2,2,3));
    }


}
