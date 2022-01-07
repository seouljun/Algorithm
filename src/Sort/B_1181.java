package Sort;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class B_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] list = new String[n];

        for (int i = 0; i < n; i++) {
            list[i] = br.readLine();
        }
        Arrays.sort(list, (o1, o2) -> {
            if (o1.length() > o2.length())
                return 1;
            else if (o1.length() < o2.length())
                return -1;
            else
                return o1.compareTo(o2);
        });

        Arrays.stream(list)
                .distinct()
                .forEach(x -> {
                    try {
                        bw.write(x + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bw.flush();
        bw.close();
        br.close();
    }
}
