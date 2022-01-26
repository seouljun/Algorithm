package DP;

import java.util.Scanner;

public class B_11722 {
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
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max,doFunction(i));
        }
        System.out.println(max);

    }

    private static int doFunction(int n) {
        if(d[n] == null){
            d[n] = 1;
            for(int i = n-1; i >=0 ; i--){
                if(arr[i] > arr[n]){
                    d[n] = Math.max(d[n],doFunction(i)+1);
                }
            }
        }
        return d[n];
    }
}
