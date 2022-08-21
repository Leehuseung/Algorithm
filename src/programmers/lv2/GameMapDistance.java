package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Lv2. 게임 맵 최단거리
 *
 * DFS로 풀고 효율성 실패로 BFS로 풀이.
 */
public class GameMapDistance {

    static boolean[][] bools = null;
    static int answer = -1;
    public static int solution(int[][] maps) {
        bools = new boolean[maps.length][maps[0].length];
        Cordinate cordinate = new Cordinate(0,0,1);

        Queue<Cordinate> queue = new LinkedList<>();
        queue.add(cordinate);

        while(!queue.isEmpty()){
            Cordinate pollCordinate = queue.poll();
            int row = pollCordinate.getRow();
            int col = pollCordinate.getCol();
            if(row < 0 || col < 0 || row > maps.length-1 || col > maps[0].length-1){
                continue;
            }
            if(bools[row][col] == true){
                continue;
            }
            bools[row][col] = true;

            if(row == maps.length-1 && col == maps[0].length-1 && answer == -1){
                answer = pollCordinate.getNumber();
            } else if(row == maps.length-1 && col == maps[0].length-1){
                answer = Math.min(pollCordinate.getNumber(), answer);
            }
            if(row+1 <= maps.length-1 && maps[row+1][col] == 1){ //아래
                queue.add(new Cordinate(row+1,col,pollCordinate.getNumber()+1));
            }
            if(col+1 <= maps[0].length-1 && maps[row][col+1] == 1){ //오른쪽
                queue.add(new Cordinate(row,col+1,pollCordinate.getNumber()+1));
            }
            if(row-1 >= 0 && maps[row-1][col] == 1){ //위로
                queue.add(new Cordinate(row-1,col,pollCordinate.getNumber()+1));
            }
            if(col-1 >= 0 && maps[row][col-1] == 1){ //왼쪽
                queue.add(new Cordinate(row,col-1,pollCordinate.getNumber()+1));
            }
        }
        return answer;
    }

    static class Cordinate{
        public Cordinate(int row, int col, int number) {
            this.row = row;
            this.col = col;
            this.number = number;
        }
        int row;
        int col;
        int number;
        public int getRow() {
            return row;
        }
        public int getCol() {
            return col;
        }
        public int getNumber() {
            return number;
        }
        public void setNumber(int number) {
            this.number = number;
        }
    }

//DFS를 이용한 풀이
/*
    static boolean[][] bools = null;
    static int answer = -1;
    public static int solution(int[][] maps) {
        bools = new boolean[maps.length][maps[0].length];
        dps(maps,0,0,0);
        return answer;
    }

    private static void dps(int[][] maps, int row, int col,int depth) {
        if(row < 0 || col < 0 || row > maps.length-1 || col > maps[0].length-1){
            return;
        }
        if(maps[row][col] == 0){
            return;
        }
        if(bools[row][col] == true){
            return;
        }
        ++depth;
        if(answer != -1 && depth >= answer){
            return;
        }
        bools[row][col] = true;
        if(row == maps.length-1 && col == maps[0].length-1 && answer == -1){
            answer = depth;
        } else if(row == maps.length-1 && col == maps[0].length-1){
            answer = Math.min(depth, answer);
        }
        dps(maps,row+1,col,depth); //아래
        dps(maps,row,col+1,depth);  //오른쪽
        dps(maps,row-1,col,depth); //위
        dps(maps,row,col-1,depth); //왼쪽
        bools[row][col] = false;
    }
*/

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        }));
        System.out.println(solution(new int[][]{
                 {1,0,1,1,1},
                 {1,0,1,0,1},
                 {1,0,1,1,1},
                 {1,1,1,0,0},
                 {0,0,0,0,1}
        }));
        System.out.println(solution(new int[][]{
                 {1},
        }));
    }
}
