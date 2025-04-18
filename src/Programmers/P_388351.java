package programmers;

/**
 * 프로그래머스 사이트를 운영하는 그렙에서는 재택근무와 함께 출근 희망 시각을 자유롭게 정하는 유연근무제를 시행하고 있습니다. 제도 정착을 위해 오늘부터 일주일 동안 각자 설정한 출근 희망 시각에 늦지 않고 출근한 직원들에게 상품을 주는 이벤트를 진행하려고 합니다.
 *
 * 직원들은 일주일동안 자신이 설정한 출근 희망 시각 + 10분까지 어플로 출근해야 합니다. 예를 들어 출근 희망 시각이 9시 58분인 직원은 10시 8분까지 출근해야 합니다. 단, 토요일, 일요일의 출근 시각은 이벤트에 영향을 끼치지 않습니다. 직원들은 매일 한 번씩만 어플로 출근하고, 모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현됩니다. 예를 들어 10시 13분은 1013이 되고 9시 58분은 958이 됩니다.
 *
 * 당신은 직원들이 설정한 출근 희망 시각과 실제로 출근한 기록을 바탕으로 상품을 받을 직원이 몇 명인지 알고 싶습니다.
 *
 * 직원 n명이 설정한 출근 희망 시각을 담은 1차원 정수 배열 schedules, 직원들이 일주일 동안 출근한 시각을 담은 2차원 정수 배열 timelogs, 이벤트를 시작한 요일을 의미하는 정수 startday가 매개변수로 주어집니다. 이때 상품을 받을 직원의 수를 return 하도록 solution 함수를 완성해주세요.
 */
public class P_388351
{
    public static void main(String[] args)
    {
        int[][] timelogs = {
            {710, 700, 650, 735, 700, 931, 912},
            {908, 901, 805, 815, 800, 831, 835},
            {705, 701, 702, 705, 710, 710, 711},
            {707, 731, 859, 913, 934, 931, 905}
        };
        int[] schedules = {730, 855, 700, 720};

        Solution solution = new Solution();
        int solution1 = solution.solution(schedules, timelogs, 1);
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;

            //first
            for (int employeeIdx = 0; employeeIdx < schedules.length; employeeIdx++)
            {
                int startTemp = startday;

                int schedule = schedules[employeeIdx];
                int schHour = schedule / 100;
                int schMinute = schedule % 100;

                int schMax = schMinute + 10 >= 60 ? (schHour + 1) * 100 + schMinute - 50 : schHour * 100 + schMinute + 10;

                boolean isSuccess = false;

                for (int timeIdx = 0; timeIdx < timelogs[employeeIdx].length; timeIdx++)
                {

                    if (startTemp == 6)
                    {
                        startTemp++;
                        continue;
                    }
                    else if(startTemp == 7)
                    {
                        startTemp = 1;
                        continue;
                    }

                    int timelog = timelogs[employeeIdx][timeIdx];

                    if(timelog <= schMax)
                    {
                        isSuccess = true;
                        startTemp++;
                    }
                    else
                    {
                        isSuccess = false;
                        break;
                    }
                }

                answer = isSuccess ? answer+1 : answer;
            }


            return answer;
        }
    }
}

