package recursion;

import java.io.*;
import java.util.Scanner;

public class B_11729 {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // 시작(1)에서 보조(2)를 사용하여 목적지(3)으로 이동
        Hanoi(n,1,2,3);
        bw.write(count + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void Hanoi(int n, int start, int sub, int destination) {
        count++;
        if(n==1){
            sb.append(start+ " " + destination + "\n");
            return;
        }
        // 1 -> 2
        // A에서 n-1개만큼 B로 이동(가장 큰 원반 제외)
        Hanoi(n-1,start,destination,sub);
        // A에서 C로 가장 큰 원반 이동
        sb.append(start + " " + destination + "\n");
        // 2 -> 3
        // B에서 C로 나머지 모두 이동(n-1)
        Hanoi(n-1,sub,start,destination);
    }


}
