package recursion;

import java.io.*;

public class B_2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        printStar(n);
        bw.flush();
        bw.close();
        br.close();
    }

    static void printStar(int value) {
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                if(i%3== 1 && j%3==1) {
                    System.out.print(" ");
                }
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
