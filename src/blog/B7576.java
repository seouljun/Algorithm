package blog;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    static int M;
    static int N;
    static int[][] map;
    static int[][] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 가로 개수
        M = Integer.parseInt(st.nextToken());
        // 세로 개수
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        Queue<int[]> queue = new ArrayDeque<>();

        int[] dm = {1, -1, 0, 0};
        int[] dn = {0, 0, 1, -1};

        for (int[] ints : dist) {
            Arrays.fill(ints, -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                map[i][j] = tomato;
                if (tomato == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int n = poll[0];
            int m = poll[1];
            int cnt = dist[n][m];

            for (int i = 0; i < 4; i++) {
                int newN = n + dn[i];
                int newM = m + dm[i];

                if(newN >= 0 && newN < N && newM >= 0 && newM < M) {
                    if (dist[newN][newM] == -1 && map[newN][newM] == 0) {
                        queue.offer(new int[]{newN, newM});
                        map[newN][newM] = 1;
                        dist[newN][newM] = cnt + 1;
                        answer = Math.max(dist[newN][newM], answer);
                    }
                }
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

        bw.write(answer + "\n");
        bw.flush();
    }
}
