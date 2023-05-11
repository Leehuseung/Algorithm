package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

/**
 * Lv2. 할인 행사
 *
 * 문제를 제대로 읽지 못했다.
 *
 * 최초의 셋째 날이 아니라,
 *
 * 셋째, 넷째, 다섯째 날 3일이기 때문에 3을 리턴한다.
 */
public class DiscountEvent {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int total = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) map.put(want[i], i);
        for (int i = 0; i < number.length; i++) total += number[i];

        int[] arr;
        for (int i = 0; i < discount.length-total+1; i++) {
            arr = new int[want.length];
            int k = 0;
            while(k < total){
                if(map.containsKey(discount[i+k])){
                    ++arr[map.get(discount[i+k])];
                }
                k++;
            }
            if(same(arr,number)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean same(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{
                        "chicken", "apple", "apple", "banana", "rice",
                        "apple", "pork", "banana", "pork", "rice",
                        "pot", "banana", "apple", "banana"
                }
        )); // 3
        System.out.println(solution(
                new String[]{"banana"},
                new int[]{1},
                new String[]{
                        "chicken", "apple", "apple", "banana", "rice",
                        "apple", "pork", "banana", "pork", "rice",
                        "pot", "banana", "apple", "banana"
                }
        )); // 4
        System.out.println(solution(
                new String[]{"apple"},
                new int[]{10},
                new String[]{
                        "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"
                }
        )); // 0
    }
}
