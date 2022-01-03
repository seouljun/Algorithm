package Math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 주어진 수 N개 중에서 소수가 몇 개 인지 찾아서 출력하는 프로그램을 작성하시오
 */
public class B_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int count2 = count;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(count > 0){
            int value = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int i = 1; i <= value; i++){
                if(value % i == 0 && value != 1){
                    cnt++;
                }
                if(cnt == 3 || value == 1){
                    count2--;
                    break;
                }
            }
            count--;
        }
        bw.write(count2+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
