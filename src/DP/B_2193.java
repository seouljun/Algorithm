package DP;

import java.util.Scanner;

public class B_2193 {
    static int[][] d;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1][2];
        int result = 0;
        for(int i = 0 ; i < 2; i++){
            result += doCal(n,i);
        }
        System.out.println(result);
    }

    private static int doCal(int n, int value) {
        if(n==1){
            if(value == 0)
                return 0;
            else
                return 1;
        }

        if(d[n][value] != 0) return d[n][value];

        if(value == 1){
            d[n][value] = doCal(n-1,0);
        }
        else{
            d[n][value] = doCal(n-1,0) + doCal(n-1,1);
        }

        return d[n][value];
    }
}
