package leetcode.easy;

/**
 * 1742. Maximum Number of Balls in a Box
 */
public class MaximumNumberofBallsinaBox {
    public static int countBalls(int lowLimit, int highLimit) {
        int answer = 0;
        int[] arr = new int[highLimit+1];

        for (int i = lowLimit; i <= highLimit; i++) {
            if(i > 9){
                String s = i + "";
                int total = 0;
                for (int j = 0; j < s.length(); j++) {
                    total += Integer.parseInt(s.charAt(j) + "");
                }
                arr[total] = arr[total]+1;
                answer = Math.max(answer,arr[total]);
            } else {
                arr[i] = arr[i]+1;
                answer = Math.max(answer,arr[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countBalls(1,10));
        System.out.println(countBalls(5,15));
        System.out.println(countBalls(19,28));
    }
}
