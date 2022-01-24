package DP;

import java.util.Scanner;

/**
 * 오르막 수
 * 계단수와 비슷하게 생각하면 될 듯 싶다.
 */
public class B_11057 {
    // 1: 자리수 (길이)                  1부터 시작하므로 n+1
    // 2: 끝자리 수(오르막수 판별을 위함)   0~9까지 있으므로 10
    static int[][] d;
    static int[][] d2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1][10];
        d2 = new int[n + 1][10];
        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
            d2[1][i] = 1;
        }
        int result = 0;
        int result2 = 0;
        for (int i = 0; i <= 9; i++) {
            result += doCal(n, i);
        }
        result2 += doCalB(n);
        System.out.println(result % 10007);
        System.out.println(result2 % 10007);

    }

    //Top-down
    private static int doCal(int n, int value) {
        if (n == 1) {
            return d[n][value];
        }
        if (d[n][value] != 0) return d[n][value];
        for (int i = 0; i <= value; i++) {
            d[n][value] += doCal(n - 1, i);
        }
        return d[n][value] % 10007;
    }

    //Bottom-up
    private static int doCalB(int n) {
        int result = 0;
        if (n == 1) {
            return 1;
        }
        //길이 n인 (자리수 n인) 모든 오르막 수를 구해야 하므로
        //d[n]의 모든 개수를 구한다 -> d[n][0] ~ d[n][9]의 갯수를 구한다.
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for(int k = 0 ; k <= j; k++){
                    d2[i][j] += d2[i-1][k];
                }
            }
        }
        for(int i = 0 ; i <= 9;i++){
            result += d2[n][i];
        }
        return result % 10007;
    }
}
