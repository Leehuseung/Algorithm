package backjun.math;

/**
 * 패션왕 신해빈
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class A1375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, List<String>> clothes = new HashMap<>();

            // 의상의 종류별로 선택할 수 있는 경우의 수를 계산
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];

                if (clothes.containsKey(type)) {
                    clothes.get(type).add(input[0]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(input[0]);
                    clothes.put(type, list);
                }
            }

            // 각 의상의 종류별로 선택할 수 있는 경우의 수를 모두 곱함
            int answer = 1;
            for (List<String> list : clothes.values()) {
                answer *= (list.size() + 1); // 해당 의상을 입지 않는 경우도 포함하기 위해 +1
            }

            // 알몸인 경우를 제외하고 출력
            bw.write((answer - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}