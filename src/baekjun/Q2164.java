package baekjun;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 가장 상위에 있는 숫자를 버리고, 그 다음 가장 상위에 있는 숫자를 가장 아래로 옮기면서 1개의 수가 남을 때 그 수를 출력해야한다.
 * 상위 숫자를 하위에 넣는다에서 Queue를 사용 하면 좋겠다는 생각이 들어서 Queue를 사용함
 */
public class Q2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        if (n == 1) {
            bw.write(n + "\n");
        } else {
            while (true)
            {
                queue.poll();
                Integer poll = queue.poll();
                if (queue.isEmpty()) {
                    bw.write(poll + "\n");
                    break;
                } else {
                    queue.add(poll);
                }
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
