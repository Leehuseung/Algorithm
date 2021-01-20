package programmers.lv1;

import java.util.Arrays;

public class DartGame {
    public static void main(String[] args) {
        solution("1D2S#10S");
    }
    public static int solution(String dartResult) {
        int answer = 0;
        int[] arr = new int[3];
        int index = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            String a = dartResult.charAt(i)+"";
            try{
                int num = Integer.parseInt(a);
                arr[index++] = num;
                int now = index-1;
                //10은 별도로 검사가 필요하다..
                if(i != dartResult.length()-1 && (dartResult.charAt(i+1)+"").equals("0")){
                   arr[now] = 10;
                   i++;
                }
            }catch(Exception e){
                int now = index-1;
                switch (a){
                    case "S" :
                    break;
                    case "D" :
                        arr[now] = arr[now] * arr[now];
                    break;
                    case "T" :
                        arr[now] = arr[now] * arr[now] * arr[now];
                    break;
                    case "*" :
                        arr[now] = arr[now] * 2;
                        if(now != 0){
                            arr[now-1] = arr[now-1] * 2;
                        }
                    break;
                    case "#" :
                        arr[now] = arr[now] * -1;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        System.out.println(answer);
        return answer;
    }
}
