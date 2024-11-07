package If;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.StringTokenizer;

public class B_2525 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String nowString = br.readLine();
        StringTokenizer st = new StringTokenizer(nowString);
        String hour = st.nextToken();
        String second = st.nextToken();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        Date date = sdf.parse(hour + ":" + second);
        System.out.println(date.getTime());
    }
}
