package leetcode.easy;

/**
 * 2169. Count Operations to Obtain Zero
 */
public class CountOperationstoObtainZero {
    public static int countOperations(int num1, int num2) {
        int answer = 0;
        while(num1 != 0 && num2 != 0){
            answer++;
            if(num1 >= num2){
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countOperations(2,3));
        System.out.println(countOperations(10,10));
        System.out.println(countOperations(5,4));
    }
}
