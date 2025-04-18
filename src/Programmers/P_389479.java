package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P_389479
{
    public static void main(String[] args)
    {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;

        Solution solution = new Solution();

        System.out.println(solution.solution(players, m, k));
    }

    static class Solution {
        public int solution(int[] players, int m, int k) {
            int answer = 0;
            List<Integer> list = new ArrayList<>();

            for (int player : players)
            {
                list = list.stream().map(v -> v - 1).collect(Collectors.toList());
                list.removeIf(v -> v == 0);

                if (player >= m)
                {
                    int size = list.size();
                    int availableUsers = (size + 1) * m;

                    if (availableUsers <= player)
                    {
                        int addServers = (player - availableUsers) / m + 1;
                        for (int j = 0; j < addServers; j++)
                        {
                            list.add(k);
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
