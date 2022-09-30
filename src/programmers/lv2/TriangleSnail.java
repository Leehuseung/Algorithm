package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 삼각 달팽이
 *
 * 22.07.14
 *
 * 22.07.20
 */
public class TriangleSnail {
    static int num = 0;
    public static int[] solution(int n) {
        num = 0;

        int[][] triangle = new int[n][];

        int total = 0;
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i+1];
            total += i+1;
        }
        int leftStart = 0;
        int leftEnd = triangle.length;
        int right = 0;

        int bottomStart = 1;
        int bottomEnd = triangle.length;
        int left = triangle.length-1;

        int slashStart = triangle.length-2;
        int slashEnd = 1;
        int slashRight = triangle.length-2;
        whi:
        while(true){
            for (int i = leftStart; i < leftEnd; i++) {
                triangle[i][right] = ++num;
                if(num == total){
                    break whi;
                }
            }
            leftStart += 2;
            leftEnd -= 1;
            right++;

            for (int i = bottomStart; i < bottomEnd; i++) {
                triangle[left][i] = ++num;
                if(num == total){
                    break whi;
                }
            }
            ++bottomStart;
            bottomEnd -= 2;
            --left;

            int k = slashRight;
            for (int i = slashStart; i >= slashEnd; i--) {
                triangle[i][k] = ++num;
                if(num == total){
                    break whi;
                }
                k--;
            }
            slashRight -= 2;
            slashStart -= 1;
            slashEnd += 2;
        }

        int[] answer = new int[num];
        int t = 0;
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                answer[t++] = triangle[i][j];
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1)));  // [1]
        System.out.println(Arrays.toString(solution(2)));  // [1]
        System.out.println(Arrays.toString(solution(3)));  // [1]
        System.out.println(Arrays.toString(solution(4)));  // [1,2,9,3,10,8,4,5,6,7]
        System.out.println(Arrays.toString(solution(5)));  // [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
        System.out.println(Arrays.toString(solution(6)));  // [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]

    }
}
