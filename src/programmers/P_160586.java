package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 대충 만든 자판
 * 문자열을 작성할때 최소 몇번 눌러야하는가
 */
public class P_160586
{
    public static void main(String[] args)
    {
        // String[] keymap = { "ABACD", "BCEFD" };
        // String[] target = { "ABCD", "AABB" };
        String[] keymap = { "AA" };
        String[] target = { "B", "BGZ" };
        int[] solution = solution(keymap, target);
        for (int i : solution)
        {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] keymap, String[] targets)
    {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for (String key : keymap)
        {
            char[] charArray = key.toCharArray();
            for (int i = 0; i < charArray.length; i++)
            {
                Integer cnt = map.get(charArray[i]);
                if (cnt == null || cnt > i + 1)
                {
                    map.put(charArray[i], i + 1);
                }
            }
        }


        for (int i = 0; i < targets.length; i++)
        {
            char[] charArray = targets[i].toCharArray();
            int cntSum = 0;
            for (char c : charArray)
            {
                Integer cnt = map.get(c);
                if (cnt == null)
                {
                    cntSum = -1;
                    break;
                }
                else
                {
                    cntSum+=cnt;
                }
            }

            answer[i] = cntSum;
        }
        return answer;
    }
}
