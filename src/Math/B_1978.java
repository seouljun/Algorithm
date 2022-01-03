package Math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 주어진 수 N개 중에서 소수가 몇 개 인지 찾아서 출력하는 프로그램을 작성하시오
 * 제곱근 풀이
 */
public class B_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(n > 0){
            int value = Integer.parseInt(st.nextToken());
            boolean isPrime = true;

            if(value == 1){
                n--;
                continue;
            }
            for(int i = 2; i <= Math.sqrt(value); i++){
                if(value % i == 0){
                    isPrime = false;
                }
            }
            if(isPrime)
                count++;

            n--;
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
