package leetcode.easy;

/**
 * 1822. Sign of the Product of an Array
 */
public class SignoftheProductofanArray {

    public static int arraySign(int[] nums) {
        int product = 1;
        for (int num : nums) {
            if(num < 0){
                product *= -1;
            } else if(num == 0){
                product = 0;
            }
        };

        if(product > 0){
            return 1;
        } else if(product < 0){
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(arraySign(new int[]{-1,-2,-3,-4,3,2,1}));
    }
}
