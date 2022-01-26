package programmers.lv1;

public class MakeDecimal {

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isDeci(sum)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1,2,3,4}));
        System.out.println(solution(new int[]{1,2,7,6,4}));
    }

    public static boolean isDeci(int a){
        for (int i = 2; i < a; i++) {
            if(a % i == 0){
                return false;
            }
        }

        return true;
    }
}
