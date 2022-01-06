package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class B_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        Character[] arr = new Character[n.length()];
        for(int i = 0 ; i < n.length() ; i++){
            arr[i] = n.charAt(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for(Character x : arr)
            bw.write(x);
        bw.flush();
        bw.close();
        br.close();
    }
}
