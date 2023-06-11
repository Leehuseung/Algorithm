package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Lv2. 미로 탈출
 *
 * 23.06.11
 */
public class MazeEscape {

    public static String[][] cMaps;
    public static boolean[][] bools;
    public static int l = Integer.MAX_VALUE;
    public static int e = Integer.MAX_VALUE;

    public static int solution(String[] maps) {
        cMaps = new String[maps.length][maps[0].length()];
        bools = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) cMaps[i] = maps[i].split("");

        for (int i = 0; i < cMaps.length; i++) {
            for (int j = 0; j < cMaps[0].length; j++) {
                if(cMaps[i][j].equals("S")) bfs(i, j,  "L");
                bools = new boolean[maps.length][maps[0].length()];
                if(cMaps[i][j].equals("L")) bfs(i, j,  "E");
            }
        }

        return (l == Integer.MAX_VALUE || e == Integer.MAX_VALUE) ? -1 : l + e;
    }

    private static void bfs(int y, int x, String  find) {
        Queue<int[]> queue = new LinkedList<>();

        if(y < cMaps.length-1){
            queue.add(new int[]{y+1,x,1});
        }
        if(x < cMaps[0].length-1){
            queue.add(new int[]{y,x+1,1});
        }
        if(y > 0){
            queue.add(new int[]{y-1,x,1});
        }
        if(x > 0){
            queue.add(new int[]{y,x-1,1});
        }

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int yy = arr[0];
            int xx = arr[1];
            int cc = arr[2];
            if(bools[yy][xx] || cMaps[yy][xx].equals("X")) {
                continue;
            }
            bools[yy][xx] = true;
            if(cMaps[yy][xx].equals(find)){
                if(find.equals("L")){
                    l = Math.min(cc, l);
                } else {
                    e = Math.min(cc, e);
                }
            }
            if(yy < cMaps.length-1){
                queue.add(new int[]{yy+1,xx,cc+1});
            }
            if(xx < cMaps[0].length-1){
                queue.add(new int[]{yy,xx+1,cc+1});
            }
            if(yy > 0){
                queue.add(new int[]{yy-1,xx,cc+1});
            }
            if(xx > 0){
                queue.add(new int[]{yy,xx-1,cc+1});
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));//16
//        System.out.println(solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));//-1
//        System.out.println(solution(new String[]{"SOEOL","XXXXO","OOOOO","OXXXX","OOOOO"}));//6
//        System.out.println(solution(new String[]{"SLEOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO"}));//2
//        System.out.println(solution(new String[]{"SELOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO"}));//3
//        System.out.println(solution(new String[]{"SLXOX", "EXXXO", "OOOOO", "OXXXX", "OOOOO"}));//3
        System.out.println(solution(new String[]{"SXXOX", "EXXXL", "OOXOO", "OXXXX", "OOOOO"}));//-1
    }
}
