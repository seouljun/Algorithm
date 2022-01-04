package Recursion;

import java.io.*;

public class B_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(fibo(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int fibo(int value){
        if(value == 0)
            return 0;
        else if(value == 1)
            return 1;
        else
            return fibo(value-1) + fibo(value-2);
    }
}
