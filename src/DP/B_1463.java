package DP;

import java.util.Scanner;

/**
 * 1로 만들기
 * Input : 정수 N
 * Output : 1을 만드는 횟수의 최솟값
 */
public class B_1463 {
    static int[] d; // n을 1로 만드는데 필요한 연산의 최솟값
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        System.out.println(doSolve(n));
    }

    private static int doSolve(int n) {
        if(n==1){
            return 0;
        }
        if(d[n] > 0) return d[n];
        d[n] = doSolve(n-1)+1;
        if(n % 3 == 0){
            int temp = doSolve(n/3) + 1;
            if(temp < d[n])
                d[n] = temp;
        }
        if(n%2 == 0){
            int temp = doSolve(n/2) + 1;
            if(temp < d[n])
                d[n] = temp;
        }
        return d[n];
    }
}
