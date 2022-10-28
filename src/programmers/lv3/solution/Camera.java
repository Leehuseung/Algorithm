package programmers.lv3.solution;

import java.util.Arrays;

/**
 * Lv3. 단속 카메라
 *
 * 슈도코드 참고
 */
public class Camera {

    public static int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int camera = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if(routes[i][0] <= camera){
                continue;
            }
            camera = routes[i][1];
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20,-15},{-14,-5},{-18,-13},{-5,-3}}));
    }
}
