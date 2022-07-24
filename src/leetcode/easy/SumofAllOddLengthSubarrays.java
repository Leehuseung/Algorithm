package leetcode.easy;

/**
 * 1588. Sum of All Odd Length Subarrays
 */
public class SumofAllOddLengthSubarrays {
    static int answer = 0;
    public static int sumOddLengthSubarrays(int[] arr) {
        answer = 0;

        for (int i = 0; i < arr.length; i++) {
            add(arr,i);
        }
        return answer;
    }

    private static void add(int[] arr, int i) {
        int len = arr.length;
        for (int j = i; j < arr.length; j+=2) {
            for (int k = i; k <= j; k++) {
                answer += arr[k];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3})); // 58
        System.out.println(sumOddLengthSubarrays(new int[]{1,2})); // 3
        System.out.println(sumOddLengthSubarrays(new int[]{10,11,12})); // 66
    }
}
