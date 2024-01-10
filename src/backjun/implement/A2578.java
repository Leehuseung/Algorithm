package backjun.implement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 빙고
 */
public class A2578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer[]> xyInfo = new HashMap<>();
        Map<String, Integer> map = new HashMap<>(){};
        map.put("x0",0);
        map.put("x1",0);
        map.put("x2",0);
        map.put("x3",0);
        map.put("x4",0);
        map.put("y0",0);
        map.put("y1",0);
        map.put("y2",0);
        map.put("y3",0);
        map.put("y4",0);
        map.put("s1",0);
        map.put("s2",0);

        int[][] arr = new int[5][];

        for (int i = 0; i < 5; i++) {
            arr[i] = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
                xyInfo.put(arr[i][j], new Integer[]{i,j} );
            }
        }

        int sum = 0;
        for (int i = 0; i < 25; i++) {
            int tt = sc.nextInt();
            Integer[] xy = xyInfo.get(tt);
            int x = xy[0];
            int y = xy[1];

            arr[x][y] = 0;

            String xx = "x" + xy[0];
            String yy = "y" + xy[1];

            map.put(xx, map.get(xx) + 1);
            if(map.get(xx) == 5){
                sum++;
                if(sum == 3){
                    System.out.println(i+1);
                }
            }

            map.put(yy, map.get(yy) + 1);
            if(map.get(yy) == 5){
                sum++;
                if(sum == 3){
                    System.out.println(i+1);
                }
            }

            if(x == y){
                map.put("s1", map.get("s1") + 1);
                if(map.get("s1") == 5){
                    sum++;
                    if(sum == 3){
                        System.out.println(i+1);
                    }
                }
            }
            if(x + y == 4){
                map.put("s2", map.get("s2") + 1);
                if(map.get("s2") == 5){
                    sum++;
                    if(sum == 3){
                        System.out.println(i+1);
                    }
                }
            }
        }
    }
}
