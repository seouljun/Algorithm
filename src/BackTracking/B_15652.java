package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class B_15652 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int m;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dfs(1, 0);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start, int depth) throws IOException {
        if (n == depth) {
            for (int x : arr)
                bw.write(x + " ");
            bw.write("\n");
            return;
        }
        for (int i = start; i <= m; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
