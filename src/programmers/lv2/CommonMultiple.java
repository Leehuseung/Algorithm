package programmers.lv2;

/**
 * Lv2. 최대공약수 만들기
 */
public class CommonMultiple {

    public static int solution(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            arr[i+1] = func(arr[i],arr[i+1]);
        }
        return arr[arr.length-1];
    }
    public static int func(int a, int b){
        int answer = 1;
        while(!(answer%a == 0 && answer%b==0)) answer++;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14})); // 168
        System.out.println(solution(new int[]{1,2,3}));    // 6
        System.out.println(solution(new int[]{2,7}));    // 14
    }
}
