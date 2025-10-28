package baekjun;

import java.io.*;
import java.util.StringTokenizer;

/**
 * DFS로 푼 문제
 * DFS 활용해서 재귀로 풀었음.
 * BFS로 풀려면 큐 이용해서 풀 수 있을듯.
 * 함수 진입 경계 설정 주의해서 문제 풀것.
 */
public class Q1012 {
    static boolean[][] graph;
    static boolean[][] visit;
    static int width;
    static int height;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newY >= 0 && newX < width && newY < height)
            {
                if (graph[newX][newY] && !visit[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            graph = new boolean[width][height];
            visit = new boolean[width][height];

            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = true;
            }
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (graph[x][y] && !visit[x][y]) {
                        cnt++;
                        dfs(x, y);
                    }
                }
            }
            bw.write(cnt + "\n");
        }

        // output
        bw.flush();
        bw.close();
        br.close();
    }
}
