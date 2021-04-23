package String;

import java.io.*;

public class B_2941 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cl[] = {"c=", "c-" , "dz=", "d-", "lj", "nj", "s=", "z="};
        String input = br.readLine();

        for(String data : cl){
            input = input.replace(data,"1");
        }

        bw.write(String.valueOf(input.length()) + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
