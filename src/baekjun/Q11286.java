package baekjun;

import java.io.*;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> Math.abs((int) v)).thenComparing(v -> (int) v));

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                pq.offer(input);
            }
            else  {
                Integer poll = pq.poll();
                bw.write(Objects.requireNonNullElse(poll, 0) + "\n");
            }
        }
        bw.flush();
    }
}
