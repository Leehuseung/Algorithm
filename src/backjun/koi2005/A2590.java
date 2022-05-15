package backjun.koi2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[7];

        int count = 0;

        for (int i = 1; i <= 6; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //6은 한개필요
        count += arr[6];

        //5는 한개 기본필요
        count += arr[5];
        //5는 1개를 넣고 1이 11개 들어갈 수있음.
        arr[1] -= arr[5] * 11;

        //4는 한개 기본 필요이
        count += arr[4];
        arr[2] -= arr[4] * 5;

        //3의색종이가 4개인경우만큼 count를 증가해줘야한다.9
        if(arr[3] >= 4){
            count += arr[3] / 4;
            arr[3] = arr[3] % 4;
        }
        //3의판으로 남는 2와 1을 붙힐 숫자
        if(arr[3] > 0){
            count++;
            //2먼저
            arr[2] -= (7 - (2 * arr[3]));
            //그다음 1
            arr[1] -= (8 - arr[3]);
        }


        //2색종이이 남아있다면
        if(arr[2] > 0){
            count += (arr[2] - 1)/9 + 1;
            //남은걸로 1붙힘
            if(arr[2] % 9 != 0){
                arr[1] -= (9 - arr[2] % 9) * 4;
            }
        } else {
            //2가 -라면 그만큼 1을 넣어줄수 있음.
            arr[1] += arr[2] * 4;
        }

        //그래도 1이남았다면
        if(arr[1] > 0){
            count += (arr[1] - 1)/36 + 1;
        }
        System.out.println(count);

    }
}
