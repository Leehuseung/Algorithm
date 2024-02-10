package backjun.graph;

import java.util.Scanner;

/**
 * 미친 로봇
 */
public class A1405 {

    static int[] dx = {0, 0, 1, -1}; //동 서 남 북 순서
    static int[] dy = {1, -1, 0, 0};
    static double[] percent;
    static boolean[][] visited;
    static double result;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        percent = new double[4];
        for(int i = 0; i < 4; i++) {
            percent[i] = scan.nextInt() * 0.01;
        }

        visited = new boolean[30][30]; //시작점을 15, 15로 잡기 위함.
        result = 0;
        dfs(15, 15, 0, n, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int idx, int n, double total) {
        if(idx == n) {
            System.out.println(x + ", " + y);
            result += total;
            return;
        }

        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < 30 && ny < 30) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, idx + 1, n, total * percent[i]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
//    static int[][] dir = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
//    static boolean[][] visited;
//    static double result;
//    static int n;
//    static double E;
//    static double W;
//    static double S;
//    static double N;
//    static double[] arr;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        E = Double.parseDouble(st.nextToken()) / 100;
//        W = Double.parseDouble(st.nextToken()) / 100;
//        S = Double.parseDouble(st.nextToken()) / 100;
//        N = Double.parseDouble(st.nextToken()) / 100;
//        arr = new double[]{E,W,S,N};
//        result = 0;
//
//        for (int i = 0; i < 4; i++) {
//            visited = new boolean[29][29];
//            visited[14][14] = true;
//            if(arr[i] != 0){
//                dfs(i, 1.0, 1, 14, 14);
//            }
//
//        }
//
//        System.out.printf("%.9f\n", result); // 소수점 아래 9자리까지 출력
//
//    }
//
//    private static void dfs(int x, double d, int depth, int xx, int y) {
//        //현재위치 계산
//        if(x == 0){
//            xx += 1;
//        }else if (x == 1){
//            xx -= 1;
//        }else if (x == 2){
//            y += 1;
//        }else if (x == 3){
//            y -= 1;
//        }
//        if(visited[xx][y]) {
//            return;
//        }
//        visited[xx][y] = true;
//        d *= arr[x];
//        if(depth == n) {
//            result += d;
//            System.out.println(xx  + ", " + y);
//            return;
//        }
//
//        if(arr[0] != 0) dfs(0, d, depth+1, xx, y); // 동
//        visited[xx][y] = false;
//        if(arr[1] != 0) dfs(1, d, depth+1, xx, y); // 서
//        visited[xx][y] = false;
//        if(arr[2] != 0) dfs(2, d, depth+1, xx, y); // 남
//        visited[xx][y] = false;
//        if(arr[3] != 0) dfs(3, d, depth+1, xx, y); // 북
//        visited[xx][y] = false;
//    }
//}
