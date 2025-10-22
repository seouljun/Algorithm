package baekjun;

import java.io.*;
import java.util.StringTokenizer;

/*
첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)

두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.

따라서 블록 내부의 빈 공간이 생길 수 없다. 또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.

G5
 */
public class Q14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input1 = br.readLine();
        String input2 = br.readLine();

        StringTokenizer st = new StringTokenizer(input1, " ");

        st.nextToken();
        int widthCount = Integer.parseInt(st.nextToken());

        int[] block = new int[widthCount];

        st = new StringTokenizer(input2, " ");

        for (int i = 0; i < widthCount; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;

        for (int i = 0; i < block.length; i++) {
            int left = 0;
            int right = 0;

            int height = block[i];

            // left max
            for (int j = 0; j < i; j++) {
                right = Math.max(right, block[j]);
            }
            // right max
            for (int j = i + 1; j < widthCount; j++) {
                left = Math.max(left, block[j]);
            }
            // cal
            if (height < left && height < right) {
                sum += Math.min(right, left) - height;
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}
