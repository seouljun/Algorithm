package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class B_18108
{
    public static void main(String[] args) throws IOException
    {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int num = 2541 - 1998;
        String s = br.readLine();
        Integer x = Integer.parseInt(s) - num;
        bw.write(x.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
