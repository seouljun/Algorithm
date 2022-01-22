package BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B_14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static boolean[] judge;
    static int min = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        judge = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        doFind(0, 0);
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void doFind(int index, int count) {
        //가지치기 조건
        if (count == n / 2) {
            cal();
            return;
        }
        for (int i = index; i < n; i++) {
            judge[i] = true;
            doFind(i + 1, count + 1);
            judge[i] = false;
        }
    }

    private static void cal() {
        int startTeam = 0;
        int linkTeam = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (judge[i] && judge[j]) {
                    startTeam += arr[i][j] + arr[j][i];
                } else if (!judge[i] && !judge[j]) {
                    linkTeam += arr[i][j] + arr[j][i];
                }
            }
        }
        int minus = Math.abs(startTeam-linkTeam);
        if(minus < min){
            min = minus;
        }
    }
}
