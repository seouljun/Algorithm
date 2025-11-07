package baekjun;

import java.io.*;
import java.util.*;

public class Q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());

        }

        int cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            int d = K / coins[i];
            int m = K % coins[i];
            cnt += d;
            K = m;
            if (m == 0) {
                bw.write(cnt + "\n");
                bw.flush();
                return;
            }
        }
    }
}
