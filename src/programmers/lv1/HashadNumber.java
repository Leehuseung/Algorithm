package programmers.lv1;

public class HashadNumber {
    public static void main(String[] args) {

    }
    public static boolean solution(int x) {
        String a = x+"";

        int total = 0;

        String[] arr = a.split("");

        for (int i = 0; i < arr.length; i++) {
            total += Integer.parseInt(arr[i]);
        }

        if(x%total == 0){
            return true;
        } else {
            return false;
        }
    }
}
