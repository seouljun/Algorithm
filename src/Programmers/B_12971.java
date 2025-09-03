package programmers;

public class B_12971
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] { 1, 3, 2, 5, 4 }));
    }
    static class Solution {
        public int solution(int[] sticker) {
            int n = sticker.length;
            if (n == 1) return sticker[0];
            if (n == 2) return Math.max(sticker[0], sticker[1]);

            // 1. 첫 번째 스티커를 고른 경우
            int[] dp1 = new int[n];
            dp1[0] = sticker[0];
            dp1[1] = dp1[0];
            for (int i = 2; i < n - 1; i++) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
            }

            // 2. 첫 번째 스티커를 고르지 않은 경우
            int[] dp2 = new int[n];
            dp2[1] = sticker[1];
            for (int i = 2; i < n; i++) {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
            }

            return Math.max(dp1[n - 2], dp2[n - 1]);
        }
    }
}
