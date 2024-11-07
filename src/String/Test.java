package String;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class Test
{
    public static void main(String[] args)
    {
        solution("2022.05.19", new String[] { "A 6", "B 12", "C 3" },
            new String[] { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" });
    }
    public static int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;

        Map<String, Integer> termsMap = new HashMap<>();

        Date nowDate = stringToDate(today);

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
            String date = st.nextToken();
            String termsName = st.nextToken();
            Date parseDate = stringToDate(date);

            Integer duration = termsMap.get(termsName);
            if(isOver(nowDate, parseDate, duration))
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

    private static Date stringToDate(String s)
    {
        StringTokenizer st = new StringTokenizer(s, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }

    private static boolean isOver(Date source, Date target, int termsMonth)
    {
        long targetTime = target.getTime();
        long sourceTime = source.getTime();

        long dayDiff = TimeUnit.MILLISECONDS.toDays(sourceTime - targetTime);

        //TODO dayDiff to Month

        return dayDiff > termsMonth;
    }
}
