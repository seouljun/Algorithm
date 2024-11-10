package Programmers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/*
개인정보 수집 유효기간

느낀점
1. 문제 제대로 읽기
2. 진법의 특성을 제대로 파악하기 -> 해당 문제에서는 월(달)을 이용하기 때문에 12진법을 사용

다른사람의 풀이를 보고 느낀점

나도 처음엔 다 일로 계산해서 풀려고 했다.
근데 28일이라고 값이 오니 당황했고, (년,월,일)을 따로 계산하려고 했다.
그럴필요가 없었다.
year to day => year * 12 * 28
month to day => month * 28
day => day
...
 */
public class Question_1
{
    public static void main(String[] args)
    {
        String first = "2022.05.19";
        String[] second = new String[]{"A 6", "B 12", "C 3"};
        String[] third = new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] solution = solution(first, second, third);

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;

        Map<String, Integer> termsMap = new HashMap<>();

        // set termsMap
        for (String term : terms)
        {
            st = new StringTokenizer(term, " ");
            String termsName = st.nextToken();
            int duration = Integer.parseInt(st.nextToken());

            termsMap.put(termsName, duration);
        }

        // set
        int i = 1;
        List<Integer> integerList = new ArrayList<>();
        for (String privacy : privacies)
        {
            st = new StringTokenizer(privacy, " ");
            String targetDate = st.nextToken();
            String termsName = st.nextToken();

            Integer duration = termsMap.get(termsName);
            boolean over = isOver(today, targetDate, duration);
            if(over)
            {
                integerList.add(i);
            }
            i++;
        }


        int[] answer = new int[integerList.size()];

        for (int j = 0; j < integerList.size(); j++)
        {
            answer[j] = integerList.get(j);
        }

        return answer;
    }

    private static LocalDate stringToLocalDate(String s)
    {
        StringTokenizer st = new StringTokenizer(s, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        return LocalDate.of(year, month, day);
    }

    //날짜 계산 함수
    private static boolean isOver(String todayString, String targetDate, int termsMonth)
    {
        int monthUnit = 12;

        // return day unit
        int day;
        int month;
        int year;

        // 주어진 오늘 날짜
        LocalDate today = stringToLocalDate(todayString);
        // 주어진 약관 가입 날짜
        LocalDate target = stringToLocalDate(targetDate);

        // target's day, month, year
        day = target.getDayOfMonth();

        int targetMonth = target.getMonthValue();
        int targetYear = target.getYear();

        int i = termsMonth % monthUnit;

        year = (termsMonth + targetMonth) / monthUnit;

        if (i == 0) {
            month = targetMonth;
        }
        else {
            if ((termsMonth + targetMonth) % monthUnit == 0) {
                month = 12;
                year = (termsMonth + targetMonth) / monthUnit - 1;
            }
            else {
                month = (termsMonth + targetMonth) % monthUnit;
            }
        }

        year += targetYear;

        LocalDate afterDate = LocalDate.of(year, month, day);

        return today.isAfter(afterDate) || today.isEqual(afterDate);
    }
}
