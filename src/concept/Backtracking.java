package concept;

/**
 * [1,2,3] 배열에서 만들수 있는 모든 배열을 순회.
 *
 * [1],[2],[3]
 * [1,2],[1,3],[2,1],[2,3],[3,1],[3,2]
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
 *
 *
 * 다음 배열도 재귀로 만들어보자.
 * [1],[2],[3]
 * [1,2],[1,3],[3,2]
 * [1,2,3]
 */
public class Backtracking {
    static String[] arr = new String[]{"1","2","3","4"};
    static boolean[] bools = new boolean[arr.length];

    public static void main(String[] args) {

        for (int i = 0; i < arr.length; i++) {
            
        }
    }

    public static void recursion(String[] arr, int i, String a){

    }
}

//    public static void main(String[] args) {
//
//        for (int i = 0; i < arr.length; i++) {
//            backtrack(i,arr[i]);
//        }
//
//
//    }
//
//    private static void backtrack(int i, String s) {
//        bools[i] = true;
//        if (s.length() == 4) {
//            System.out.println(s);
//        }
//
//        for (int j = 0; j < arr.length; j++) {
//            if(!bools[j]){
//                backtrack(j,s+arr[j]);
//            }
//        }
//        bools[i] = false;
//    }




//    public static void recursion(String[] arr, int i, String a){
//        bools[i] = true;
//
//        a += arr[i] + "";
//
//        System.out.println(a);
            //return 여부 차이에 따라 1,2,3,,, ,중복으로 실행할지 선택할 수 있다.
//
//        for (int j = 0; j < bools.length; j++) {
//            if(!bools[j]){
//                recursion(arr,j,a);
//                bools[j] = false;
//            }
//        }
//
//        bools[i] = false;
//    }


//main
//        for (int i = 0; i < arr.length; i++) {
//
//
//        recursion();
//        }

//            recursion(arr,i,"");



