package programmers.lv2;

import java.util.HashMap;

/*
 *  자바 백트래킹을 이용한 구현
 *  속도로 실패...
 *
 */
public class Camouflage {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));

    }

    static int answer = 0;

    public static int solution(String[][] clothes) {

        boolean[] visited = new boolean[clothes.length];

        HashMap<String,String> map = new HashMap<>();

        for (int i = 1; i <= clothes.length; i++) {
            combination(clothes, visited, 0, clothes.length, i,map);
        }


        return answer;
    }
    static void combination(String[][] arr, boolean[] visited, int start, int n, int r,HashMap<String, String> map) {
        if (r == 0) {
            print(arr, visited, n, map);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, map);
            visited[i] = false;
        }
    }
    static void print(String[][] arr, boolean[] visited, int n,HashMap<String,String> map) {
        map = new HashMap<>();
        boolean a = true;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                String[] arr2 = arr[i];
                if(map.containsValue(arr2[1])){
                    a = false;
                }
                map.put(arr2[0],arr2[1]);
            }
        }
        if(a){
            answer++;
        }
    }
}
