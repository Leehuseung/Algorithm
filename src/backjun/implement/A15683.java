package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 감시
 */
public class A15683 {
    static int ccc = 0;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    static List<int[]> cctvList;
    static boolean[][][] visited;
    static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        cctvList = new ArrayList<>();
        visited = new boolean[r][c][4];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = st.nextToken();
                if(!map[i][j].equals("6") && !map[i][j].equals("0")){
                    cctvList.add(new int[]{i,j,Integer.parseInt(map[i][j])});
                }
            }
        }
        cnt = cctvList.size();
        dfs(-1, new ArrayList<Cctv>());

        System.out.println(min);
    }

    private static void dfs(int aa, ArrayList<Cctv> cctvs) {
        if(aa == cnt-1) {
            ccc++;
            // #을 채우고
            String[][] cloneMap = map.clone();
            for (int i = 0; i < map.length; i++) {
                cloneMap[i] = map[i].clone();
            }
            for (int i = 0; i < cctvs.size(); i++) {
                Cctv cctv = cctvs.get(i);
                cctv.fillMap(cloneMap);
            }
            // #의 개수를 센다.
            int cnt = 0;
            for (int i = 0; i < cloneMap.length; i++) {
                for (int j = 0; j < cloneMap[i].length; j++) {
                    if(cloneMap[i][j].equals("0")) cnt ++;
                }
            }
            min = Math.min(min, cnt);
            return;
        }

        for (int i = aa+1; i < cctvList.size(); i++) {
            int[] cctvInfo = cctvList.get(i);
            int r = cctvInfo[0];
            int c = cctvInfo[1];
            int t = cctvInfo[2];
            for (int j = 0; j < 4; j++) {
                if(!visited[r][c][j]){
                    visited[r][c][j] = true;
                    cctvs.add(new Cctv(r,c,t+"",j));
                    dfs(i, cctvs);
                    cctvs.remove(cctvs.size()-1);
                    visited[r][c][j] = false;
                }
            }
        }
    }

    static class Cctv {
        int r;
        int c;
        String type;
        int dir;

        public Cctv(int r, int c, String type, int dir) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.dir = dir;
        }

        public void fillMap(String[][] cloneMap) {
            if(type.equals("1")) {
                if(dir == 0){
                    goRight(cloneMap);
                } else if(dir == 1){
                    goLeft(cloneMap);
                } else if(dir == 2){
                    goDown(cloneMap);
                } else if(dir == 3){
                    goUp(cloneMap);
                }
            }else if(type.equals("2")) {
                if(dir == 0 || dir == 1){
                    goRight(cloneMap);
                    goLeft(cloneMap);
                } else {
                    goUp(cloneMap);
                    goDown(cloneMap);
                }
            }else if(type.equals("3")) {
                if(dir == 0){
                    goUp(cloneMap);
                    goRight(cloneMap);
                } else if(dir == 1){
                    goUp(cloneMap);
                    goLeft(cloneMap);
                } else if(dir == 2){
                    goLeft(cloneMap);
                    goDown(cloneMap);
                } else if(dir == 3){
                    goDown(cloneMap);
                    goRight(cloneMap);
                }
            }else if(type.equals("4")) {
                if(dir == 0){
                    goLeft(cloneMap);
                    goUp(cloneMap);
                    goRight(cloneMap);
                } else if(dir == 1){
                    goUp(cloneMap);
                    goRight(cloneMap);
                    goDown(cloneMap);
                } else if(dir == 2){
                    goRight(cloneMap);
                    goDown(cloneMap);
                    goLeft(cloneMap);
                } else if(dir == 3){
                    goLeft(cloneMap);
                    goUp(cloneMap);
                    goDown(cloneMap);
                }
            }else if(type.equals("5")) {
                goRight(cloneMap);
                goLeft(cloneMap);
                goDown(cloneMap);
                goUp(cloneMap);
            }
        }

        public void goLeft(String[][] cloneMap) {
            int r = this.r;
            int c = this.c;
            while(this.c-1 >= 0) {
                this.c -= 1;
                if(cloneMap[this.r][this.c].equals("6")) break;
                if(cloneMap[this.r][this.c].equals("0")) {
                    cloneMap[this.r][this.c] = "#";
                }
            }
            this.r = r;
            this.c = c;
        }

        public void goRight(String[][] cloneMap) {
            int r = this.r;
            int c = this.c;
            while(this.c+1 < map[0].length) {
                this.c += 1;
                if(cloneMap[this.r][this.c].equals("6")) break;
                if(cloneMap[this.r][this.c].equals("0")) {
                    cloneMap[this.r][this.c] = "#";
                }
            }
            this.r = r;
            this.c = c;
        }

        public void goUp(String[][] cloneMap) {
            int r = this.r;
            int c = this.c;
            while(this.r-1 >= 0) {
                this.r -= 1;
                if(cloneMap[this.r][this.c].equals("6")) break;
                if(cloneMap[this.r][this.c].equals("0")) {
                    cloneMap[this.r][this.c] = "#";
                }
            }
            this.r = r;
            this.c = c;
        }

        public void goDown(String[][] cloneMap) {
            int r = this.r;
            int c = this.c;
            while(this.r+1 < map.length) {
                this.r += 1;
                if(cloneMap[this.r][this.c].equals("6")) break;
                if(cloneMap[this.r][this.c].equals("0")) {
                    cloneMap[this.r][this.c] = "#";
                }
            }
            this.r = r;
            this.c = c;
        }
    }
}
