package programmers;

// 모르겠다
public class P_150369
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        System.out.println(solution.solution(cap, n, deliveries, pickups));
    }
    static class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = -1;
            int delivery = 0;
            int pickup = 0;
            for (int i = n-1; i >= 0; i--)
            {
                delivery -= deliveries[i];
                pickup -= pickups[i];

                while (delivery < 0 || pickup < 0)
                {
                    delivery -= deliveries[i];
                    pickup -= pickups[i];
                    if (delivery == 0 && pickup == 0)
                    {
                        break;
                    }
                }

            }

            return answer;
        }
    }
}
