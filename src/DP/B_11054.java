package DP;

import java.util.Scanner;

public class B_11054 {
    static int[] arr;
    static Integer[] d;
    static Integer[] d2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        d = new Integer[n + 1];
        d2 = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            findIncrease(i);
            findDecrease(i);
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(d[i]+d2[i],max);
        }
        System.out.println(max-1);

    }

    private static int findIncrease(int n) {
        if(d[n] == null){
            d[n] = 1;
            for (int i = n - 1; i > 0; i--) {
                if (arr[i] < arr[n]) {
                    d[n] = Math.max(d[n], findIncrease(i) + 1);
                }
            }
        }
        return d[n];
    }

    private static int findDecrease(int n) {
        if (d2[n] == null) {
            d2[n] = 1;
            for (int i = n + 1; i < d2.length; i++) {
                if (arr[i] < arr[n]) {
                    d2[n] = Math.max(d2[n], findDecrease(i) + 1);
                }
            }
        }
        return d2[n];
    }
}
