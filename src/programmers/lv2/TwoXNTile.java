package programmers.lv2;

/**
 * Lv2. 2 x n 타일링
 */
public class TwoXNTile {
    public static int solution(int n) {
        int[] arr = new int[n];
        if(n == 1) return 1;
        if(n == 2) return 2;
        int k = 1;
        arr[0] = 1;
        arr[1] = 2;
        while(++k != n){
            arr[k] = (arr[k-1] + arr[k-2]) % 1000000007;
        }
        return arr[n-1];
    }
    public static void main(String[] args) {
        System.out.println(solution(1)); // 1
        System.out.println(solution(2)); // 2
        System.out.println(solution(3)); // 3
        System.out.println(solution(4)); // 5
        System.out.println(solution(5)); // 8
        System.out.println(solution(6)); // 13
    }
}
