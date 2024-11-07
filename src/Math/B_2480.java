package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B_2480
{
    /*
    같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
    같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
    모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.

    입력 첫째 줄에 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.
    출력 첫째 줄에 게임의 상금을 출력 한다.
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        int price = cal(first, second, third);

        bw.write(price + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int cal(int first, int second, int third)
    {
        int price = 0;

        List<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);

        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        set.add(first);
        set.add(second);
        set.add(third);

        int i = set.stream().findFirst().orElse(0);

        // all match set size > 3
        if (set.size() == 1)
        {
            price = 10000 + i * 1000;
        }
        // 1 match
        else if (set.size() == 2)
        {
            long count = list.stream().filter(v -> v == first).count();
            if (count == 1)
            {
                price = 1000 + second * 100;
            }
            else
            {
                price = 1000 + first * 100;
            }
        }
        // no match
        else
        {
            price = i * 100;
        }

        return price;
    }

}
