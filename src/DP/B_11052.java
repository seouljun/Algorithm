package DP;

import java.util.Scanner;

/**
 * 카드 구매하기
 */
public class B_11052 {
    static String[] arr;
    static int[] d;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        arr = sc.nextLine().split(" ");

        d = new int[n+1];
        System.out.println(doCal(n));
    }

    private static int doCal(int n) {
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <=i ; j++){
                if(d[i] < d[i-j] + Integer.parseInt(arr[j-1])){
                    d[i] = d[i-j] + Integer.parseInt(arr[j-1]);
                }
            }
        }
        return d[n];
    }
}
