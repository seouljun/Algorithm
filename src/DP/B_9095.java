package DP;

import java.util.Scanner;

/**
 * 1, 2, 3 더하기
 */
public class B_9095 {
    static int[] d = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        doCount(10);
        for(int i = 0; i < t ; i++){
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }

    private static int doCount(int n) {
        if (n == 1){
            d[n] = 1;
            return 1;
        }
        if (n == 2) {
            d[n] = 2;
            return 2;
        }
        if (n == 3) {
            d[n] = 4;
            return 4;
        }
        if (d[n] > 0) return d[n];

        d[n] = doCount(n - 1) + doCount(n - 2) + doCount(n - 3);
        return d[n];
    }
}
