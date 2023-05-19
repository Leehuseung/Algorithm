package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 숫자 카드 나누기
 */
public class DivideNumberCards {
    public static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int aFirst = arrayA[0];
        int max = 0;
        a:
        for (int i = aFirst; i >=2; i--) {
            if(aFirst % i == 0){
                for (int j = 0; j < arrayA.length; j++) {
                    if(arrayA[j] % i != 0){
                        continue a;
                    }
                }
                max = i;
                break;
            }
        }

        boolean a = true;
        if(max != 0){
            for (int i = 0; i < arrayB.length; i++) {
                if(arrayB[i] % max == 0){
                    a = false;
                    max = 0;
                    break;
                }
            }
        }

        int max2 = 0;
        int bFirst = arrayB[0];
        b:
        for (int i = bFirst; i >=2; i--) {
            if(bFirst % i == 0){
                for (int j = 0; j < arrayB.length; j++) {
                    if(arrayB[j] % i != 0){
                        continue b;
                    }
                }
                max2 = i;
                break;
            }
        }

        boolean c = true;
        if(max2 != 0){
            for (int i = 0; i < arrayA.length; i++) {
                if(arrayA[i] % max2 == 0){
                    c = false;
                    max2 = 0;
                    break;
                }
            }
            if(c) {
                max = Math.max(max,max2);
            };
        }

        return max;
    }
    public static void main(String[] args) {
        System.out.println(solution(
                        new int[]{10,10,10, 17},
                        new int[]{5, 20}
                ));// 0
        System.out.println(solution(
                new int[]{10, 20, 20, 20},
                new int[]{5, 17}
        ));// 10
        System.out.println(solution(
                new int[]{14, 35, 119},
                new int[]{18, 30, 102}
        ));// 7
        System.out.println(solution(
            new int[]{18, 30, 102},
            new int[]{14, 35, 119}
        ));// 7
        System.out.println(solution(
                new int[]{5},
                new int[]{8}
        ));// 7
        System.out.println(solution(
                new int[]{10,20},
                new int[]{20}
        ));// 0
    }
}
