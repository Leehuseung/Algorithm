package programmers.lv2;

import java.util.*;

/**
 * Lv2. 거리두기 확인하기
 */
public class KeepDistance {

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < places[i].length; j++) {
                char[] arr = places[i][j].toCharArray();
                for (int k = 0; k < arr.length; k++) {
                    if(arr[k] == 'P'){
                        list.add(j + "," +k);
                    }
                }
            }

            //List에는 P의 위치가 들어있다. P끼리 거리를 검증하고, 거리가 2 이하이면 파티션존재 유무를 검사하자.
            for (int j = 0; j < list.size(); j++) {
                for (int k = j+1; k < list.size(); k++) {
                    String[] p1 = list.get(j).split(",");
                    String[] p2 = list.get(k).split(",");

                    int x1 = Integer.parseInt(p1[0]);
                    int y1 = Integer.parseInt(p1[1]);

                    int x2 = Integer.parseInt(p2[0]);
                    int y2 = Integer.parseInt(p2[1]);

                    if(Math.abs(x1-x2) + Math.abs(y1-y2) <= 2){
                        if(Math.abs(x1 - x2) == 2){
                            int z = (x1 + x2)/2;
                            if(places[i][z].charAt(y1) != 'X'){
                                answer[i] = 0;
                            }
                        } else if(Math.abs(y1 - y2) == 2){
                            int z = (y1 + y2)/2;
                            if(places[i][x1].charAt(z) != 'X'){
                                answer[i] = 0;
                            }
                        } else if((Math.abs(x1 - x2) == 1) && ((Math.abs(y1 - y2) == 1))){
                            if(y1 > y2 && (places[i][x1].charAt(y1-1) != 'X' || places[i][x2].charAt(y2+1) != 'X')){
                                answer[i] = 0;
                            } else if(y2 > y1 && (places[i][x1].charAt(y1+1) != 'X' || places[i][x2].charAt(y2-1) != 'X')){
                                answer[i] = 0;
                            }
                        } else if (Math.abs(x1-x2) + Math.abs(y1-y2) == 1){
                            answer[i] = 0;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][] {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        })));// {1,0,1,1,1]
    }
}
