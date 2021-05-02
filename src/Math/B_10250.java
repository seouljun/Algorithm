package Math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * input
 * t -> 돌리는 횟수
 * h -> 층 수
 * w -> 방수
 * n -> 몇 번째 손님
 * output
 * 방번호
 */
public class B_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            /*if(n%h != 0){
                if((n/h + 1) > 9)
                    bw.write(n%h + "" + (n/h +1) + "\n");
                else
                    bw.write(n%h + "0" + (n/h +1) + "\n");
            } else{
                if((n/h) > 9)
                    bw.write(h + "" + (n/h) + "\n");
                else
                    bw.write(h + "0" + (n/h) + "\n");
            }*/

            if(n%h != 0){
                bw.write((n%h) * 100 + (n/h +1) + "\n");
            } else{
                bw.write((h * 100) + (n/h) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
