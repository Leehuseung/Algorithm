package programmers.lv2;
/*
 * Lv2. 타겟 넘버 DPS
 */
public class TargetNumber {

    static int returnInt = 0;
    static int staticTarget = 0;
    static int[] staticNumbers = null;

    public static int solution(int[] numbers, int target) {
        staticNumbers = numbers;
        staticTarget = target;
        recursiveSum(0, 0);
        return returnInt;
    }

    public static void recursiveSum(int i, int sum){
        if(i == staticNumbers.length){
            if(sum == staticTarget){
                returnInt++;
            }
        } else {
            recursiveSum(i+1, sum + staticNumbers[i]);
            recursiveSum(i+1, sum - staticNumbers[i]);
        }
    };

    public static void main(String[] args) {

//        int[] arr1 = {1,1,1,1,1};
//        System.out.println(solution(arr1,3));

//        int[] arr2 = {4,1,2,1};
//        System.out.println(solution(arr2,2));


    }
}
