package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1459 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());

        long slide = Math.min(x,y);      //대각선수
        long linear = Math.max(x,y) - slide;     //직선수
        long second = 0;     //이동시간


        //대각선으로 이동한 수. 직선 or 대각선으로 작은 숫자로 이동 했음.
        if(2 * w < s){
            second = w * 2 * slide;
        } else {
            second = slide * s;
        }


        if (2 * s <  2 * w){
            //대각선2번으로 직선을 이동할 수 있음
            if(linear % 2 == 0){
                second += linear * s;
            } else if(linear % 2 == 1) {
                second += w;    //직선으로 한칸 가고나서
                linear--;       //직선 하나 줄이고
                //나머지는 대각선을 이용해 간다.
                second += linear * s;
            }
        //남은 직선을 이동하자.
        } else {
            second += linear * w;
        }
        System.out.println(second);
    }
}