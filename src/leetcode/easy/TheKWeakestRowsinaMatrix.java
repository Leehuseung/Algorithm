package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1337. The K Weakest Rows in a Matrix
 */
public class TheKWeakestRowsinaMatrix {

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] answer = new int[k];
        RowInfo[] rows = new RowInfo[mat.length];
        for (int i = 0; i < mat.length; i++) {
            RowInfo rowInfo = new RowInfo();
            rowInfo.number = i;
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1){
                    rowInfo.cnt++;
                }
            }
            rows[i] = rowInfo;
        }

        Arrays.sort(rows, new Comparator<RowInfo>() {
            @Override
            public int compare(RowInfo o1, RowInfo o2) {
                if(o1.cnt - o2.cnt > 0){
                    return 1;
                } else if (o1.cnt - o2.cnt < 0){
                    return -1;
                }
                return 0;
            }
        });

        for (int i = 0; i < k; i++) {
            answer[i] = rows[i].number;
        }

        return answer;
    }

    static class RowInfo {
        int number;
        int cnt;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            kWeakestRows(new int[][]{
                            {1,1,0,0,0},
                            {1,1,1,1,0},
                            {1,0,0,0,0},
                            {1,1,0,0,0},
                            {1,1,1,1,1}},
                        3)
        ));
    }
}
