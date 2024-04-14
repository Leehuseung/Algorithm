package backjun.bruteforce;

import java.io.*;

/**
 * 영화감독 숌
 */
public class A1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0; // 종말의 수가 666인 경우 카운트
        int num = 665; // 종말의 수가 666인 경우에 대한 변수

        while (true) {
            num++; // 다음 수로 이동
            if (String.valueOf(num).contains("666")) { // "666"이 포함되어 있는지 확인
                count++; // 카운트 증가
            }
            if (count == N) { // N번째 종말의 수에 도달하면 출력하고 종료
                bw.write(String.valueOf(num));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
