package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주 시식
 */
public class B_2156 {
    static int[] arr;
    static Integer[][] d;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        d = new Integer[n + 1][3];

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, doCal(n, i));
        }
        System.out.println(max);
    }

    private static int doCal(int n, int status) {
        if(n <= 0){
            return 0;
        }
        if(d[n][status] != null) return d[n][status];

        if(status == 0){ //0번 연속
            d[n][status] = Math.max(Math.max(doCal(n-1,0), doCal(n-1,1)), doCal(n-1,2));
            return d[n][status];
        }
        else if(status == 1){ //1번 연속
            d[n][status] = doCal(n-1,0) + arr[n-1];
            return d[n][status];
        }
        else{
            d[n][status] = doCal(n-1,1) + arr[n-1];
            return d[n][status];
        }
    }
}
