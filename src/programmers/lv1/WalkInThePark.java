package programmers.lv1;

import java.util.Arrays;

/**
 * Lv1. 공원 산책
 */
public class WalkInThePark {

    public static int[] solution(String[] park, String[] routes) {
        String[][] parks = new String[park.length][];
        int x = 0;
        int y = 0;

        for (int i = 0; i < park.length; i++) {
            parks[i] = park[i].split("");
        }

        a:
        for (int i = 0; i < parks.length; i++) {
            for (int j = 0; j < parks.length; j++) {
                if(parks[i][j].equals("S")){
                    x = j;
                    y = i;
                    break a;
                }
            }
        }

        a:
        for (int i = 0; i < routes.length; i++) {
            String dir = routes[i].split(" ")[0];
            Integer cnt = Integer.parseInt(routes[i].split(" ")[1]);
            int move = 0;
            int drX = x;
            int drY = y;
            while(move < cnt){
                move++;
                switch (dir) {
                    case "E":
                        drX++;
                        break;
                    case "W":
                        drX--;
                        break;
                    case "S":
                        drY++;
                        break;
                    case "N":
                        drY--;
                        break;
                }
                if(drX >= parks[0].length || drX < 0 || drY < 0 || drY >= parks.length ){
                    continue a;
                }
                if(parks[drY][drX].equals("X")){
                    continue a;
                }
            }
            x = drX;
            y = drY;
        }

        return new int[]{y, x};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"SOO","OOO","OOO"},
                new String[]{"E 2","S 2","W 1"}
        )));//2,1
        System.out.println(Arrays.toString(solution(
                new String[]{"S0O","OXX","OOO"},
                new String[]{"E 2","S 2","W 1"}
        )));//0,1
        System.out.println(Arrays.toString(solution(
                new String[]{"OSO","OOO","OXO","OOO"},
                new String[]{"E 2","S 3","W 1"}
        )));//0,0
        System.out.println(Arrays.toString(solution(
                new String[]{"O0S","OOO","OXO","OOO"},
                new String[]{"N 1","N 1","N 1","N 1","N 1"}
        )));//0,0
    }
}
