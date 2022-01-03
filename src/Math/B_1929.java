package Math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 소수 구하기
 */
public class B_1929 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = m; i <= n; i++) {
            isPrime(i, bw);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void isPrime(int value, BufferedWriter bw) throws IOException {
        boolean isPrime = true;
        if (value == 1) {
            isPrime = false;
        } else {
            for(int i = 2 ; i <= Math.sqrt(value); i++){
                if(value % i == 0){
                    isPrime = false;
                    break;
                }
            }
        }
        if(isPrime){
            bw.write(value + "\n");
        }

    }
}

