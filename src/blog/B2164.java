package blog;

import java.io.*;
import java.util.ArrayDeque;

/*
블로그 포스팅 복습
First In Last Out을 이용해서 풀 것이다.
 */
public class B2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 1. queue setting
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 2. processing
        while (queue.size() > 1) {
            queue.pollFirst();
            queue.addLast(queue.pollFirst());
        }
        bw.write(queue.peekFirst() + "\n");
        bw.flush();
    }
}
