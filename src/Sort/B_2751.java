package Sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        list.forEach(x -> {
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
