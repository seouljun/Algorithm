package Math;

import java.io.*;
import java.util.StringTokenizer;

public class B_1085 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int weight = Math.min(w - x, x);
        int height = Math.min(h - y, y);

        if (weight > height)
            bw.write(height + "\n");
        else
            bw.write(weight + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
