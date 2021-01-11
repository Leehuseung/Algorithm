package programmers;

public class CountPY {

    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();

        int p = 0;
        int y = 0;

        String[] arr = s.split("");

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i].equals("p")){
                p++;
            }else if (arr[i].equals("y")){
                y++;
            }
        }

        return p == y ? true : false;
    }
}
