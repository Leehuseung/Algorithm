package programmers.lv2;

import java.util.*;

/**
 * Lv2. 방금 그 곡
 */
public class BeforeSong {

    public static String solution(String m, String[] musicinfos) {
        Music[] musics = new Music[musicinfos.length];

        for (int i = 0; i < musicinfos.length; i++) {
            String[] arr = musicinfos[i].split(",");
            musics[i] = new Music(i, arr[0], arr[1], arr[3], arr[2]);
        }

        Arrays.sort(musics, new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                if(o1.playTime - o2.playTime > 0){
                    return -1;
                } else if(o1.playTime - o2.playTime < 0){
                    return 1;
                } else {
                    if(o1.number - o2.number > 0){
                        return 1;
                    } else if(o1.number - o2.number < 0){
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        for (int i = 0; i < musics.length; i++) {
            String code = musics[i].entireCode;
            int startIndex = 0;
            while (startIndex != -1){
                if(code.indexOf(m,startIndex) > -1 && code.indexOf(m,startIndex)+m.length() < code.length() && code.charAt(code.indexOf(m,startIndex)+m.length()) == '#'){
                    if(m.charAt(m.length()-1) == '#'){
                        return musics[i].name;
                    } else {
                        startIndex = code.indexOf(m,startIndex)+1;
                    }
                } else if(code.indexOf(m,startIndex) > -1){
                    return musics[i].name;
                } else {
                    break;
                }
            }
        }

        return "(None)";
    }

    static class Music {
        public Music(int number, String startTime, String endTime, String code, String name) {
            this.number = number;
            this.startTime = startTime;
            this.endTime = endTime;
            this.code = code;
            this.name = name;
            this.playTime = getPlyTime(startTime,endTime);
            this.entireCode = getEntireCode();
        }

        private String getEntireCode() {
            String entireCode = "";
            int k = 0;
            for (int i = 0; i < playTime; i++) {
                entireCode += code.charAt(k) + "";
                k++;
                if(k != code.length() && code.charAt(k) == '#'){
                    entireCode += code.charAt(k) + "";
                    k++;
                }
                if(k == code.length()){
                    k = 0;
                }
            }
            return entireCode;
        }

        private int getPlyTime(String startTime, String endTime) {
            String[] sTime = startTime.split(":");
            int sHour = Integer.parseInt(sTime[0]) * 60;
            int sMinute = Integer.parseInt(sTime[1]);

            String[] eTime = endTime.split(":");
            int eHour = Integer.parseInt(eTime[0]) * 60;
            int eMinute = Integer.parseInt(eTime[1]);

            return (eHour + eMinute) - (sHour + sMinute);
        }

        int number;
        String startTime;
        String endTime;
        int playTime;
        String code;
        String entireCode;
        String name;

    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG",new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"})); // HELLO
        System.out.println(solution("CC#BCC#BCC#BCC#B",new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"})); // FOO
        System.out.println(solution("ABC",new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"})); // WORLD
        System.out.println(solution("CCB", new String[]{"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"})); //FOO
    }

}
