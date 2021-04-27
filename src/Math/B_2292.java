package Math;

import java.io.*;

/**
 * 1 - 1
 * 2 - 6 - 7
 * 3 - 12 - 19
 * 4 - 18 - 37
 * 5 - 24 - 61
 * 6
 * 입력 방번호 N
 * 출력 최소 개수의 방을 지나는 X
 */
public class B_2292 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int room = 1;
        int cnt = 1;

        while(room < n){
            room += 6*cnt;
            cnt++;
        }

        bw.write(cnt + "\n");

        bw.close();
        br.close();
    }
}
