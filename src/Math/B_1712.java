package Math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * A 고정비용
 * B 가변비용
 * C 노트북 가격
 * A + B * X < C * X 를 구하여라
 * <p>
 * 입력값 A, B ,C
 * 출력값 X
 */
public class B_1712 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(b > c)
            bw.write(-1 + "\n");
        else if(b == c)
            bw.write(-1 + "\n");
        else
            bw.write((a/(c-b)+1)+ "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
