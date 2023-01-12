package leetcode.easy;

/**
 * 2057. Smallest Index With Equal Value
 */
public class SmallestIndexWithEqualValue {
    public static int smallestEqual(int[] nums) {
        int answer = -1;
        for (int i = 0; i < nums.length; i++) {
            if(i % 10 == nums[i] ){
                return i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(smallestEqual(new int[]{0,1,2})); //0
        System.out.println(smallestEqual(new int[]{4,3,2,1})); //2
        System.out.println(smallestEqual(new int[]{1,2,3,4,5,6,7,8,9,0})); //-1
        System.out.println(smallestEqual(new int[]{7,8,3,5,2,6,3,1,1,4,5,4,8,7,2,0,9,9,0,5,7,1,6})); //21
    }
}
