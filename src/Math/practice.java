package Math;

import java.io.*;
import java.util.StringTokenizer;

public class practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int All_Count = Integer.parseInt(br.readLine());
        while (All_Count > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int Start_Point = Integer.parseInt(st.nextToken());
            int End_Point = Integer.parseInt(st.nextToken());
            int Cost = End_Point - Start_Point;


            All_Count--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
