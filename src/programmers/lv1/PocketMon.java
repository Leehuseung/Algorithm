package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

public class PocketMon {

    public static int solution(int[] nums) {
        int answer = nums.length/2;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if(answer > set.size()){
            return set.size();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,1,2,3}));
        System.out.println(solution(new int[] {3,3,3,2,2,4}));
        System.out.println(solution(new int[] {3,3,3,2,2,2}));
    }
}
