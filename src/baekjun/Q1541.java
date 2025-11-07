package baekjun;

import java.io.*;

public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        String[] split = input.split("-");
        int answer = 0;
        for (int i = 0; i < split.length; i++) {
            int tmp = 0;
            for (String s : split[i].split("\\+")) {
                tmp += Integer.parseInt(s);
            }
            if (i == 0) {
                answer = tmp;
            }
            else {
                answer -= tmp;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
