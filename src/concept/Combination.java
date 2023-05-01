package concept;

/**
 * [1,2,3,4] 배열에서 "-"이 들어갈 수 있는 모든 경우의 수를 재귀를 이용해 나열해보자.
 * ----
 * ---4
 * --3-
 * --34
 * -2--
 * -2-4
 * -23-
 * -234
 * 1---
 * 1--4
 * 1-3-
 * 1-34
 * 12--
 * 12-4
 * 123-
 * 1234
 */
public class Combination {
    static String[] arr = new String[] {"1", "2" ,"3", "4"};

    public static void main(String[] args) {
    }


}






//    static String[] arr = new String[] {"1", "2" ,"3", "4", "150"};
//    public static void main(String[] args) {
//        combination(0,"");
//    }
//
//    private static void combination(int i, String s) {
//        if(i == 4){{
//            System.out.println(s);
//        }
//            System.out.println(s);
//        }
//        combination(i+1,s+"-");
//        combination(i+1,s+arr[i+1]);
//    }