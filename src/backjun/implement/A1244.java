package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스위치 켜고 끄기
 */
public class A1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] switches = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        //학생수
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            //남자 or 여자?
            int qq = Integer.parseInt(st.nextToken());
            //번호
            int num = Integer.parseInt(st.nextToken());

            //남자면
            if(qq == 1) {
                for (int j = num; j <= n; j++) {
                    if(j % num == 0) {
                        if(switches[j] == 0){
                            switches[j] = 1;
                        } else {
                            switches[j] = 0;
                        }
                    }
                }
            //여자면
            } else {
                // 대칭용
                int left = num;
                int right = num;

                int realLeft = num;
                int realRight = num;

                while(left-1 > 0 && right+1 <= n) {
                    left = left - 1;
                    right = right + 1;
                    if(switches[left] == switches[right]) {
                        realLeft = left;
                        realRight = right;
                    } else {
                        break;
                    }
                }

                for (int j = realLeft; j <= realRight; j++) {
                    if(switches[j] == 0){
                        switches[j] = 1;
                    } else {
                        switches[j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            // 카운터가 20의 배수일 때 줄바꿈 출력
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
