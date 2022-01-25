package DP;

import java.util.Scanner;

public class B_11053 {
    static int[] arr;
    static Integer[] d;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        d = new Integer[n+1];
        for(int i = 1 ; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        //배열 탐색
        for(int i = 1 ; i <= n ; i++){
            dpFunction(i);
        }
        int max = 0;
        //배열 중 가장 긴 증가하는 부분 수열 길이 계산
        for(int i = 1 ; i <= n ; i++){
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }

    private static int dpFunction(int n) {
        if(d[n] == null){
            d[n] = 1;
            for(int i = n-1 ; i >= 1 ; i--){
                if(arr[i] < arr[n]){
                    d[n] = Math.max(d[n], dpFunction(i)+1);
                }
            }
        }
        return d[n];
    }
}
