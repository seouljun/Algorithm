package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_9184
{
    static int[][][] memo = new int[21][21][21];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true)
        {
            String s = br.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            if (a == -1 && b == -1 && c == -1)
            {
                break;
            }

            int w = w(a, b, c);
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w + "\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }

    static int w(int a, int b, int c)
    {
        if (0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20)
        {
            if (memo[a][b][c] != 0)
            {
                return memo[a][b][c];
            }
        }

        if (a <= 0 || b <= 0 || c <= 0)
        {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20)
        {
            return memo[20][20][20] = w(20, 20, 20);
        }

        if (a < b && b < c)
        {
            return memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
