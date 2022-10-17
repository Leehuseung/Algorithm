package programmers.lv2.solution;

import java.util.Arrays;

/**
 * Lv2. 2개 이하로 다른 비트
 *
 * 슈도코드 참조
 */
public class OtherBit {

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            String numBinary = Long.toBinaryString(num);

            if(num % 2 == 0){
                answer[i] = num + 1;
            } else {
                String compareBinary = Long.toBinaryString(num+1);
                if(numBinary.length() != compareBinary.length()){
                    numBinary = "0" + numBinary;
                }
                int index = numBinary.lastIndexOf('0');
                StringBuilder sb = new StringBuilder(numBinary);
                sb.setCharAt(index,'1');
                if(index != compareBinary.length()){
                    sb.setCharAt(index+1,'0');
                }
                long result = Long.parseLong(sb.toString(),2);
                answer[i] = result;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{2,7})));  // [2,7]
//        System.out.println(Arrays.toString(solution(new long[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40})));  // [2,7]
    }
}


