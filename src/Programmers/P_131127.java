package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P_131127
{
    public static void main(String[] args)
    {
        String[] want = { "banana", "apple", "rice", "pork", "pot" };
        int[] number = { 3, 2, 2, 2, 1 };
        String[] discount =
            { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana",
                "apple", "banana" };

        Solution solution = new Solution();
        System.out.println(solution.solution(want, number, discount));
    }

    public static class Solution
    {
        public int solution(String[] want, int[] number, String[] discount)
        {
            int answer = 0;

            int length = discount.length;

            Map<String, Integer> wantMap = new HashMap<>();

            for (int i = 0; i < want.length; i++)
            {
                wantMap.put(want[i], number[i]);
            }

            while(length >= 10)
            {
                Map<String, Integer> map = new HashMap<>();
                int cycle = discount.length - length;

                for (int i = 0; i < 10; i++)
                {
                    String sales = discount[i + cycle];
                    map.compute(sales, (k, cnt) -> cnt == null ? 1 : cnt + 1);
                }

                Set<Entry<String, Integer>> entrySet = wantMap.entrySet();
                boolean isOk = true;

                for (Entry<String, Integer> entry : entrySet)
                {
                    String wantKey = entry.getKey();
                    Integer wantValue = entry.getValue();

                    Integer discountValue = map.get(wantKey);

                    if (wantValue > (discountValue == null ? 0 : discountValue))
                    {
                        isOk = false;
                        break;
                    }
                }

                if (isOk)
                {
                    answer++;
                }

                length--;
            }

            return answer;
        }
    }
}
