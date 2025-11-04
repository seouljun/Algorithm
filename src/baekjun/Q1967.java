package baekjun;

import java.io.*;
import java.util.*;

public class Q1967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input, " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        int[] timeArray = new int[100001];
        Arrays.fill(timeArray, -1);

        timeArray[n] = 0;
        queue.offer(n);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if (poll == k) {
                break;
            }

            // x+1, x-1, x*2
            int[] dx = {poll + 1, poll - 1, poll * 2};

            for (int i = 0; i < 3; i++) {
                int next = dx[i];
                if (next < timeArray.length && next >= 0 && timeArray[next] == -1) {
                    timeArray[next] = timeArray[poll] + 1;
                    queue.offer(next);
                }
            }
        }

        bw.write(timeArray[k] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
