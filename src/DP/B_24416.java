package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_24416
{

    /**
     * 재귀, 동적 호출의 실행 횟수 차이 비교
     */

    private static int REC_CNT = 0;

    private static int DP_CNT = 0;

    private static Integer[] MEMO;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int read = Integer.parseInt(br.readLine());

        recursion(read);
        dp(read);

        bw.write(REC_CNT + " " + DP_CNT);
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 피보나치
     * n , n-1, n-2, n-3, n-4 ... 1 까지 호출
     * TOP-DOWN
     * @param n n번째 피보나치 수
     * @return
     */
    static int recursion(int n)
    {
        MEMO = new Integer[n];
        if (n == 1 || n == 2)
        {
            REC_CNT++;
            return 1;
        }
        else
        {
            return (recursion(n - 2) + recursion(n - 1));
        }
    }

    static int dp(int n)
    {
        MEMO = new Integer[n];
        MEMO[0] = 1;
        MEMO[1] = 1;
        for (int i = 2; i < n ; i++)
        {
            DP_CNT++;
            MEMO[i] = MEMO[i - 2] + MEMO[i - 1];
        }
        return MEMO[n-1];
    }
}
