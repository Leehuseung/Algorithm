package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

/**
 * Lv2. 소수 찾기
 */
public class FindPrimeNumber {

    static boolean[] bools = null;
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();


    public static int solution(String numbers) {
        String[] st = numbers.split("");
        bools = new boolean[st.length];

        for (int i = 0; i < bools.length; i++) {
            bools[i] = false;
        }

        for (int i = 0; i < st.length; i++) {
            recursion(st,i,"");
        }


        return answer;
    }

    public static void recursion(String[] arr, int i, String a){
        bools[i] = true;
        a += arr[i] + "";

        if(!a.equals("")){
            //소수인지 판단한다.
            int num = 0;
            int pp = Integer.parseInt(a);
            if(!set.contains(pp)){
                for (int j = 2; j < pp; j++) {
                    if((pp % j) == 0){
                        num++;
                    }
                }
                if(pp != 0 && pp != 1 && num == 0) {
                    answer++;
                    set.add(pp);
                }
            }
        }

        for (int j = 0; j < bools.length; j++) {
            if(!bools[j]){
                recursion(arr,j,a);
                bools[j] = false;
            }
        }

        bools[i] = false;


    }

    public static void main(String[] args) {
        System.out.println("정답은 : " +solution("17")); // 3
//        System.out.println("정답은 : " +solution("011")); // 2



        System.out.println(solution("1231"));  //18
    }
}
