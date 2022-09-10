package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> an = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = i + 1;
            if(num % 3 == 0 && num % 5 == 0){
                an.add("FizzBuzz");
            } else if(num % 3 == 0) {
                an.add("Fizz");
            } else if(num % 5 == 0) {
                an.add("Buzz");
            } else {
                an.add(num+"");
            }
        }

        return an;
    }
    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));  // 1,2,Fizz
//        System.out.println(fizzBuzz(5));  // 1,2,Fizz,4,Buzz
//        System.out.println(fizzBuzz(15));
    }
}
