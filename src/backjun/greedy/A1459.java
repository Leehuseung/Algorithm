package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1459 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int slide = 0;      //대각선수
        int linear = 0;     //직선수
        int second = 0;     //이동시간

        if(x > y){
            slide = y;
            linear = x - slide;
        } else {
            slide = x;
            linear = y - slide;
        }



        //대각선으로 이동한 수. 직선 or 대각선으로 작은 숫자로 이동 했음.
        if(2 * w < s){
            second = w * 2 * slide;
        } else {
            second = slide * s;
        }

        //남은 직선을 이동하자.
        if(2 * s > w){
            //직선이 빠를 경우
            second += linear * w;
        } else {
            //대각선2번으로 직선을 이동할 수 있음

        }




        System.out.println(second);
    }
}