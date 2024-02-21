package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 컨베이어 벨트 위의 로봇
 */
public class A20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        LinkedList<Belt> con = new LinkedList<>();
        for (int i = 0; i < n*2; i++) {
            con.add(new Belt(Integer.parseInt(st.nextToken())));
        }
        int kk = 0;
        int result = 0;
        while(true) {
            kk++;
            //1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            Belt last = con.pollLast();
            con.addFirst(last);
            if(con.get(n-1).isRobot) {
                con.get(n-1).isRobot = false;
            }
            //2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            for (int i = n-2; i >= 0; i--) {
                Belt belt = con.get(i);
                Belt beltPlus = con.get(i+1);
                if(beltPlus.n > 0 && !beltPlus.isRobot && belt.isRobot){ //로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
                    belt.isRobot = false;
                    beltPlus.isRobot = true;
                    beltPlus.n--;
                    if(beltPlus.n == 0){
                        result++;
                    }
                    if(i == n-2 && beltPlus.isRobot) {
                        beltPlus.isRobot = false;
                    }
                }
            }

            //3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            Belt first = con.peekFirst();
            if(first.n > 0){
                first.isRobot = true;
                first.n--;
                if(first.n == 0){
                    result++;
                }
            }
            Belt lastBelt = con.get(n-1);
            if(lastBelt.isRobot) lastBelt.isRobot = false;
            //4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            if(result >= k) break;
        }
        System.out.println(kk);
    }

    static class Belt {
        int n;
        boolean isRobot;
        public Belt(int n) {
            this.n = n;
        }
    }
}
