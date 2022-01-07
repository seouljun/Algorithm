package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String[][] list = new String[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            //나이
            list[i][0] = st.nextToken();
            //이름
            list[i][1] = st.nextToken();
            //가입순서
            list[i][2] = String.valueOf(i + 1);
        }
        Arrays.sort(list, ((o1, o2) -> {
            if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            } else {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        }));

        Arrays.stream(list)
                .forEach(x -> {
                    try {
                        bw.write(x[0] + " " + x[1] + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bw.flush();
        bw.close();
        br.close();
    }
}
