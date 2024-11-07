package loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_25314
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        String longString = "long ";
        String intString = "int";
        StringBuilder sb = new StringBuilder();
        int cnt = input / 4;

        for (int i = 0; i < cnt; i++)
        {
            sb.append(longString);
        }
        sb.append(intString);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
