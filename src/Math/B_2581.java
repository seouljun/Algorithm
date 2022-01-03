package Math;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 자연수 m n 주어질 때 m이상 n이하 자연수 중 소수인 것을 모두 골라 소수의 합과 최솟값을 찾는 프로그램
 */
public class B_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = m; i <= n; i++) {
            if(isPrime(i)){
                sum+=i;
                list.add(i);
            }
        }
        if(sum == 0){
            bw.write("-1");
        }
        else{
            bw.write(sum + "\n");
            bw.write(Collections.min(list) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static Boolean isPrime(int value){
        Boolean isPrime = true;
        if(value == 1)
            return false;
        else{
            for(int i = 2; i <= Math.sqrt(value); i++){
                if(value % i == 0){
                    isPrime = false;
                }
            }
            return isPrime;
        }
    }
}


