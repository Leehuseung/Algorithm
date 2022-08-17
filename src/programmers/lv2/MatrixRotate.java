package programmers.lv2;

import java.util.*;

/**
 * Lv2. 행렬 테두리 회전하기
 *
 * 22.06.25
 *
 * 22.07.07 (성공, Queue 힌트 but 그냥 위치교환으로 풀은 풀이가 많은듯..)
 */
public class MatrixRotate {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = ++value;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            circle(matrix,i,queries,answer);
        }
        return answer;
    }

    private static void circle(int[][] matrix, int i, int[][] queries,int[] answer) {
        answer[i] = Integer.MAX_VALUE;
        int x1 = queries[i][0]-1;
        int y1 = queries[i][1]-1;
        int x2 = queries[i][2]-1;
        int y2 = queries[i][3]-1;

        Queue<Integer> queue = new LinkedList();
        for (int ny1 = y1; ny1 <= y2; ny1++) {
            queue.add(matrix[x1][ny1]);
            answer[i] = Math.min(matrix[x1][ny1],answer[i]);
        }
        for (int nx1 = x1+1; nx1 <= x2; nx1++) {
            queue.add(matrix[nx1][y2]);
            answer[i] = Math.min(matrix[nx1][y2],answer[i]);
        }
        for (int ny2 = y2-1; ny2 >= y1; ny2--) {
            queue.add(matrix[x2][ny2]);
            answer[i] = Math.min(matrix[x2][ny2],answer[i]);
        }
        for (int nx2 = x2-1; x1 < nx2; nx2--) {
            queue.add(matrix[nx2][y1]);
            answer[i] = Math.min(matrix[nx2][y1],answer[i]);
        }

        for (int ny1 = y1+1; ny1 <= y2; ny1++) matrix[x1][ny1] = queue.poll();
        for (int nx1 = x1+1; nx1 <= x2; nx1++) matrix[nx1][y2] = queue.poll();
        for (int ny2 = y2-1; ny2 >= y1; ny2--) matrix[x2][ny2] = queue.poll();
        for (int nx2 = x2-1; x1 <= nx2; nx2--) matrix[nx2][y1] = queue.poll();
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}})));  //[8,10,25]
        System.out.println(Arrays.toString(solution(3,3,new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));  //[1,1,5,3]
        System.out.println(Arrays.toString(solution(100,97,new int[][]{{1,1,100,97}})));  //[1]
    }
}
