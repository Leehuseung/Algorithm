package programmers.lv2.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * lv2. 교점에 별 만들기
 *
 * 힌트정도만 확인
 *
 * 힌트 : line배열을 다룰 때 Long을 사용해야한다, 문제 하단에 x와 y를 구하는 공식을 제공한다.(선지 제대로 안읽음..)
 *
 */
public class MakeAStar {
    public static String[] solution(int[][] line) {
        List<Point> list = new ArrayList<>();

        long xMin = Long.MAX_VALUE;
        long xMax = Long.MIN_VALUE;

        long yMin = Long.MAX_VALUE;
        long yMax = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                double x = (double)((long)line[i][1] * (long)line[j][2] - (long)line[i][2] * (long)line[j][1]) / ((long)line[i][0] * (long)line[j][1] - (long)line[i][1] * (long)line[j][0]);
                double y = (double)((long)line[i][2] * (long)line[j][0] - (long)line[i][0] * (long)line[j][2]) / ((long)line[i][0] * (long)line[j][1] - (long)line[i][1] * (long)line[j][0]);
                if(Math.abs(x - (long)x) > 0 || Math.abs(y - (long)y) > 0 ){
                    continue;
                }
                xMax = (long) Math.max(xMax,x);
                xMin = (long) Math.min(xMin,x);
                yMax = (long) Math.max(yMax,y);
                yMin = (long) Math.min(yMin,y);
                list.add(new Point((long)x,(long)y));
            }
        }

        String[] answer = new String[(int)(yMax-yMin+1)];
        int t = 0;
        for (long i = yMax; i >= yMin; i--) {
            String s = "";
            for (long j = xMin; j <= xMax; j++) {
                boolean a = false;
                for (int k = 0; k < list.size(); k++) {
                    Point p = list.get(k);
                    if(p.y == i && p.x == j){
                        a = true;
                    }
                }
                if(a){
                    s += "*";
                } else {
                    s += ".";
                }
            }
            answer[t++] = s;
        }
        return answer;
    }

    static class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}}));
        System.out.println(Arrays.toString(solution(new int[][]{{0,1,-1},{1,0,-1},{1,0,1}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1,-1,0},{2,-1,0}})));
    }
}
