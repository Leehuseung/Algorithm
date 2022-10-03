package programmers.lv2;

import java.util.*;

/**
 * Lv2. 쿼드 압축 후 개수 세기
 *
 * 22.07.29
 */
public class QuadCount {
    static Queue<int[]> queue = new LinkedList<>();
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        queue.add(new int[]{0,arr.length,0,arr.length});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            recursive(poll,arr,answer);
        }

        return answer;
    }

    private static void recursive(int[] arr, int[][] param, int[] answer) {
        int sRow = arr[0];
        int eRow = arr[1];
        int sCol = arr[2];
        int eCol = arr[3];

        if(eRow - sRow == 1 || eCol - sCol == 1){
            for (int i = sRow; i < sRow+1; i++) {
                for (int j = sCol; j < sCol+1; j++) {
                    if(param[i][j] == 0){
                        answer[0] += 1;
                    } else {
                        answer[1] += 1;
                    }
                }
            }
            return;
        }

        boolean isAllEqual = true;
        int start = param[sRow][sCol];
        con:
        for (int i = sRow; i < eRow; i++) {
            for (int j = sCol; j < eCol; j++) {
                if(start != param[i][j]){
                    isAllEqual = false;
                    break con;
                }
            }
        }

        if(isAllEqual){
            if(start == 0){
                answer[0] += 1;
            } else {
                answer[1] += 1;
            }
            return;
        }
        queue.add(new int[]{sRow,(sRow+eRow)/2,sCol,(sCol+eCol)/2});
        queue.add(new int[]{sRow,(sRow+eRow)/2,(sCol+eCol)/2,eCol});
        queue.add(new int[]{(sRow+eRow)/2,eRow,sCol,(sCol+eCol)/2});
        queue.add(new int[]{(sRow+eRow)/2,eRow,(sCol+eCol)/2,eCol});
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));

        System.out.println(Arrays.toString(solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})));


    }
}
