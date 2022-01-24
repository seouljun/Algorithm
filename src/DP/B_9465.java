package DP;

import java.util.Scanner;

/**
 * 스티커
 */
public class B_9465 {
    static int[][] d;
    static int[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0 ; i < t; i++){
            int n = sc.nextInt();
            d = new int[n+1][3];
            arr = new int[2][n+1];
            int max = Integer.MIN_VALUE;

            for(int j = 0 ; j < 2 ; j++){
                for(int k = 0 ; k < n; k++){
                    arr[j][k] = sc.nextInt();
                }
            }

            for(int j = 0 ; j < 3; j++){
                max = Math.max(doCalTopDown(n,j), max);
            }
            System.out.println(max);

            d = new int[n+1][3];
            System.out.println(doCalBottomUp(n));
        }
    }
    private static int doCalBottomUp(int n){
        for(int i = 1 ; i <= n ; i++){
            d[i][0] = Math.max(d[i-1][0],Math.max(d[i-1][1],d[i-1][2]));
            d[i][1] = Math.max(d[i-1][0],d[i-1][2]) + arr[1][i-1];
            d[i][2] = Math.max(d[i-1][0],d[i-1][1]) + arr[0][i-1];
        }
        return Math.max(d[n][0],Math.max(d[n][1],d[n][2]));
    }
    private static int doCalTopDown(int n, int status) {
        if(n == 1){
            if(status == 1){
                return arr[0][0];
            }
            else if(status == 2){
                return arr[1][0];
            }
            else
                return 0;
        }
        if(d[n][status] != 0) return d[n][status];

        if(status == 0){
            d[n][status] =  Math.max(doCalTopDown(n-1,0),Math.max(doCalTopDown(n-1,2),doCalTopDown(n-1,1)));
        }
        if(status == 1){
            d[n][status] = arr[0][n-1] + Math.max(doCalTopDown(n-1,0), doCalTopDown(n-1,2));
        }
        else if(status == 2){
            d[n][status] = arr[1][n-1] + Math.max(doCalTopDown(n-1,0), doCalTopDown(n-1,1));
        }
        return d[n][status];
    }
}
