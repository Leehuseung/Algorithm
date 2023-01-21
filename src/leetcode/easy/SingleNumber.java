package leetcode.easy;

/**
 * 136. Single Number
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int[] table = new int[60002];
        for (int i = 0; i < nums.length; i++) {
            table[nums[i] + 30001] = table[nums[i] + 30001] + 1;
        }
        for (int i = 0; i < table.length; i++) {
            if(table[i] == 1){
                return i-30001;
            }
        }
        return 0;
    }

    public static int singleNumber2(int[] nums) {
        int i=0;
        for(int a: nums){
            i = i ^a;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{4,1,2,1,2}));
    }
}
