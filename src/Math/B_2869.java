package Math;

import java.io.*;
import java.util.StringTokenizer;

public class B_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        //double date = Math.ceil(V - A / (A-B)) + 2;
        int date = (V-A) / (A-B);
        if((V-A) % (A-B) != 0){
            date += 2;
        }else{
            date++;
        }

        System.out.println(date);
    }
}
