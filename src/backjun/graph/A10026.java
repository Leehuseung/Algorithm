package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 적록색약
 */
public class A10026 {
    static int N;
    static char[][] picture;
    static boolean[][] visited;

    // 상하좌우 이동을 위한 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                picture[i][j] = line.charAt(j);
            }
        }

        // 방문 배열 초기화
        visited = new boolean[N][N];
        int normalCount = countArea(false);
        visited = new boolean[N][N];
        int blindCount = countArea(true);

        // 출력
        System.out.println(normalCount + " " + blindCount);
    }

    // BFS를 사용하여 구역 수 계산
    static int countArea(boolean isBlind) {
        int count = 0; // 구역 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, isBlind);
                    count++;
                }
            }
        }
        return count;
    }

    // BFS 수행
    static void bfs(int row, int col, boolean isBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        char color = picture[row][col]; // 현재 색깔

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위를 벗어나거나 이미 방문한 경우 pass
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;

                // 적록색약인 경우 처리
                if (isBlind) {
                    // 빨강과 초록을 구분하지 않음
                    if (color == 'R' || color == 'G') {
                        if (picture[nr][nc] == 'R' || picture[nr][nc] == 'G') {
                            queue.offer(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    } else {
                        if (picture[nr][nc] == color) {
                            queue.offer(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                } else { // 적록색약이 아닌 경우
                    if (picture[nr][nc] == color) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
}
