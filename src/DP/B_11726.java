package DP;

import java.util.Scanner;

/**
 * 2 * n 타일링
 * 입력 : n
 * 출력 2 * n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지
 */
public class B_11726 {
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        System.out.println(doFill(n));
    }

    private static int doFill(int n) {
        if (n < 2) return 1;
        if (d[n] > 0) return d[n];

        d[n] = doFill(n - 1) + doFill(n - 2);
        d[n] %= 10007;

        return d[n];
    }
}
