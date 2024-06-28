package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B_25304
{
/*
첫째 줄에는 영수증에 적힌 총 금액 X가 주어진다.
둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수 N이 주어진다.
이후 N개의 줄에는 각 물건의 가격 a와 개수 b가 공백을 사이에 두고 주어진다.
 */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long allCost = Long.parseLong(br.readLine());
        int kinds = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < kinds; i++)
        {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            int cost = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            list.add((cost * count));
        }

        IntStream stream = list.stream().mapToInt(Integer::intValue);
        int sum = stream.sum();

        br.close();
        bw.write(allCost == sum ? "Yes" : "No");
        bw.flush();
        bw.close();
    }
}
