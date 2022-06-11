package leetcode.easy;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 */
public class NumberofStepstoReduceaNumbertoZero {

    public static int numberOfSteps(int num) {
        int step = 0;
        while(num != 0){
            step++;
            if(num % 2 == 0){
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14)); //14
        System.out.println(numberOfSteps(8));  //8
        System.out.println(numberOfSteps(123));  //12
    }
}
