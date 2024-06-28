package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_2525
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = br.readLine();
        int duration = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(firstLine, " ");

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        cal(hour, minute, duration, bw);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void cal(int hour, int minute, int duration, BufferedWriter bw) throws IOException
    {
        int all = minute + duration;

        int addHour = all / 60;
        int addMinute = all % 60;

        int hours = hour + addHour;

        if (hours >= 24)
        {
            hours -= 24;
        }
        bw.write(hours + " " + addMinute);
    }
}
