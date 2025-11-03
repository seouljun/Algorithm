package baekjun;

import java.io.*;
import java.util.*;

public class Q2178 {
    static int n;
    static int m;
    static boolean[][] visit;
    static boolean[][] map;
    static int[][] dist;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;

    static void bfs(int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        dist[startX][startY] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] && dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        min = dist[n - 1][m - 1];
    }


    static void dfs(int x, int y, int cnt) {
        if (x == n - 1 && y == m - 1) {
            min = Math.min(min, cnt);
            return;
        }

        if (cnt >= min) {
            return;
        }

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] && !visit[nx][ny]) {
                    dfs(nx, ny, cnt + 1);
                }
            }
        }

        visit[x][y] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visit = new boolean[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) == '1';
            }
        }

//        dfs(0,0, 1);
        bfs(0, 0);

        bw.write(min+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
