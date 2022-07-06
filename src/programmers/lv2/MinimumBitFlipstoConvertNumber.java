package programmers.lv2;

/**
 * LeetCode 2220. Minimum Bit Flips to Convert Number
 */
public class MinimumBitFlipstoConvertNumber {
    public static int minBitFlips(int start, int goal) {
        int answer = 0;

        String a = Integer.toBinaryString(start);
        String b = Integer.toBinaryString(goal);

        int m = Math.abs(a.length() - b.length());

        for (int i = 0; i < m; i++) {
            if(a.length() > b.length()){
                b = "0" + b;
            } else {
                a = "0" + a;
            }
        }

        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(minBitFlips(10,7));  //3
//        System.out.println(minBitFlips(3,4));   //3
        System.out.println(minBitFlips(10,82));   //3
    }
}
