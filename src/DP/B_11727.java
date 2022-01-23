package DP;

import java.util.Scanner;

/**
 * 2 * n 타일링 2
 * input : n
 */
public class B_11727 {
    static int[] d;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];

        System.out.println(doFill(n));

    }

    private static int doFill(int n) {
        if(n < 2) return 1;
        if(d[n] > 0) return d[n];
        d[n] = doFill(n-1) + 2 * doFill(n-2);
        d[n] %= 10007;
        return d[n];
    }
}
