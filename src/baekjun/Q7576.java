package baekjun;

import java.io.*;
import java.util.*;

public class Q7576 {
    static int[][] map;
    static int[][] dist;
    static int n;
    static int m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
              map[i][j] = Integer.parseInt(st.nextToken());
              if(map[i][j] == 1)
              {
                  queue.offer(new int[]{i, j});
                  dist[i][j] = 0;
              }
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0], x = poll[1];
            for (int i = 0; i < 4; i++) {
                int newN = y + dy[i];
                int newM = x + dx[i];

                if(newN < 0 || newM < 0 || newN >= n || newM >= m) continue;
                if(map[newN][newM] != 0) continue;
                if(dist[newN][newM] != -1) continue;

                map[newN][newM] = 1;
                // 가로 탐색에서 다음날에 익기 때문
                dist[newN][newM] = dist[y][x] + 1;
                cnt = Math.max(cnt, dist[newN][newM]);
                queue.offer(new int[]{newN, newM});
            }
        }

        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
