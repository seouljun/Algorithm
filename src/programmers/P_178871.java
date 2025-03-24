package programmers;

import java.util.HashMap;
import java.util.Map;

public class P_178871
{
    public static void main(String[] args)
    {
        String[] players = { "mumu", "soe", "poe", "kai", "mine" };
        String[] callings = { "kai", "kai", "mine", "mine" };
        String[] solution = solution(players, callings);
        for (String s : solution)
        {
            System.out.println(s);
        }
    }
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> userRankMap = new HashMap<>();

        // set rank
        for (int i = 0; i < players.length; i++)
        {
            userRankMap.put(players[i], i);
            answer[i] = players[i];
        }

        // cal
        for (String calling : callings)
        {
            Integer rank = userRankMap.get(calling);
            String front = answer[rank - 1];

            answer[rank - 1] = calling;
            answer[rank] = front;

            userRankMap.put(calling, rank - 1);
            userRankMap.put(front, rank);
        }

        return answer;
    }
}
