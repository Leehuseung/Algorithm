package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * NBA 농구
 */
public class A2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Team oneTeam = new Team();
        Team twoTeam = new Team();

        Team[] teams = new Team[3];
        Time[] times = new Time[n];
        teams[1] = oneTeam;
        teams[2] = twoTeam;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int winIndex = Integer.parseInt(st.nextToken());
            String tmp = st.nextToken();
            String[] ss = tmp.split(":");
            int winTeamIndex = oneTeam.score > twoTeam.score ? 1 : 2;
            int hour = Integer.parseInt(ss[0]);
            int minute = Integer.parseInt(ss[1]);
            Time nowTime = new Time(hour, minute);

            times[i] = nowTime;

            //그냥 지나갈 조건
            if(i==0 || oneTeam.score == twoTeam.score) {
                teams[winIndex].score++;
                continue;
            }
            teams[winIndex].score++;

            Team winTeam = teams[winTeamIndex];
            //현재시간 - 이전시간
            Time calTime = new Time(nowTime.hour, nowTime.minute);
            if(i != 0) {
                calTime.minus(times[i-1]);
            }
            winTeam.winnerTimeAdd(calTime);
        }

        // last 계산
        if(oneTeam.score != twoTeam.score){
            int winTeamIndex = oneTeam.score > twoTeam.score ? 1 : 2;
            Time calTime = new Time(48,0);
            calTime.minus(times[n-1]);
            teams[winTeamIndex].winnerTimeAdd(calTime);
        }

        for (int i = 1; i < 3; i++) {
            teams[i].print();
        }
    }
    static class Team {
        Time totalWinnerTime;
        int score;
        public void print(){
            String format1 = String.format("%02d", totalWinnerTime.hour);
            String format2 = String.format("%02d", totalWinnerTime.minute);
            System.out.println(format1+":"+format2);
        }

        public Team() {
            this.totalWinnerTime = new Time(0,0);
            score = 0;
        }
        public void winnerTimeAdd(Time time) {
            totalWinnerTime.plus(time);
        }
        public void plusScore(){
            score++;
        }
    }

    static class Time {
        int hour;
        int minute;
        public void plus(Time time) {
            this.minute += time.minute;
            if(minute >= 60){
                hour += minute / 60;
                minute = minute % 60;
            }
            this.hour += time.hour;
        }
        public void minus(Time time) {
            this.hour -= time.hour;
            if(this.minute < time.minute) {
                this.minute += 60;
                this.hour -= 1;
            }
            this.minute -= time.minute;
        }

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }
    }
}