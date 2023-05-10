package programmers.lv1;

import java.util.Arrays;

/**
 * Lv1. 바탕화면 정리
 */
public class DesktopCleanup {

    public static int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i< wallpaper.length;i++ ){
            for(int j=0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        return new int[]{minX,minY,maxX+1,maxY+1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{".#...", "..#..", "...#."}))); // 0, 1, 3, 4
        System.out.println(Arrays.toString(solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."}))); // 1,3,5,8
    }
}
