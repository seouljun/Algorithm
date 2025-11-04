package NotSolve;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)이 주어진다. 둘째 줄부터 N개의 줄에 S가 주어진다. 각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 Sij 이다. Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.
최소값 ㄱㄱ
 */

/**
 * 못풀었음
 */
public class Q14889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                list.add(array[i][j] + array[j][i]);
            }
        }

        Collections.sort(list);
        int temp = (n / 2) % 2;

        int a = 0;
        int b = 0;
        for (int i = 0; i < n / 2; i++) {
            Integer max = Collections.max(list);
            Integer min = Collections.min(list);

            if (i == (n / 2) - 1) {
                if (temp == 0) {
                    b += max + min;
                } else {
                    a += min;
                    b += max;
                }
            }
            else {
                if (i % 2 == 0) {
                    a += max + min;
                } else {
                    b += max + min;
                }
            }
        }
        int abs = Math.abs(a - b);
        bw.write(abs + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
