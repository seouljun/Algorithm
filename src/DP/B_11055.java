package DP;

import java.util.Scanner;

public class B_11055 {
    static int[] arr;
    static Integer[] d;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        d = new Integer[n+1];
        for(int i = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1 ; i <= n; i++){
            dpFunction(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            max = Math.max(max,d[i]);
        }
        System.out.println(max);
    }

    private static int dpFunction(int n) {
        if(d[n] == null){
            d[n] = arr[n];
            for(int i = n - 1; i >= 1 ;i--){
                if(arr[n] > arr[i]){
                    d[n] = Math.max(d[n],dpFunction(i) + arr[n]);
                }
            }
        }
        return d[n];
    }
}
