package leetcode.easy;

/**
 * 2154. Keep Multiplying Found Values by Two
 */
public class KeepMultiplyingFoundValuesbyTwo {
    public static int findFinalValue(int[] nums, int original) {
        while(true){
            boolean is = true;
            for (int i = 0; i < nums.length; i++) {
                if(original == nums[i]){
                    is = false;
                    original = original * 2;
                }
            }
            if(is){
                break;
            }
        }
        return original;
    }
    public static void main(String[] args) {

        System.out.println(findFinalValue(new int[]{5,3,6,1,12}, 3)); //24
        System.out.println(findFinalValue(new int[]{2,7,9},4)); // 4

    }
}
