package Recursion;

import java.io.*;

public class B_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(getFactorial(n) + "\n");
        bw.write(getFactorialUseRecursion(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int getFactorial(int value){
        int factorial = 1;
        for(int i = 1 ; i <= value; i++){
            factorial = factorial * i;
        }
        return factorial;
    }
    static int getFactorialUseRecursion(int value){
        //value가 1까지오면 재귀 종료
        //따라서 value * (value-1) * (value-2) ... 1 까지 진행
        if(value == 1)
            return 1;
        else
            return value * getFactorialUseRecursion(value-1);
    }
}
