package Math;

import java.io.*;

public class B_4948 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            if(n == 0)
                break;
            for(int i = n+1;  i <= 2*n; i++){
                if(isPrime(i)){
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean isPrime(int value){
        boolean isPrime = true;
        if(value == 1){
            return false;
        }
        else{
            for(int i = 2 ; i <= Math.sqrt(value); i++){
                if(value % i == 0){
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        }

    }
}
