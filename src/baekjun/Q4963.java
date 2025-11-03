package baekjun;

import java.io.*;
import java.util.StringTokenizer;

public class Q4963 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dw = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dh = {0, 0, 1, -1, 1, -1, 1, -1};
    static int w;
    static int h;
    static void dfs(int weight, int height) {
        visit[height][weight] = true;
        for (int i = 0; i < dw.length; i++) {
            int newW = weight + dw[i];
            int newH = height + dh[i];
            if (newW >= 0 && newH >= 0 && newW < w && newH < h) {
                if (!visit[newH][newW] && map[newH][newW] == 1) {
                    dfs(newW, newH);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            visit = new boolean[h][w];
            int cnt = 0;
            // setting
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                st = new StringTokenizer(s, " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // search
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        cnt++;
                        dfs(j, i);
                    }
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
