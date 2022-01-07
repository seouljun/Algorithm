package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 람다식 기억하기
 * Array.sort(array(T), (o1,o2) -> )
 * o1[1] - o2[1]; 오름차순
 * o2[1] - o1[1]; 내림차순
 *
 */
public class B_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] list = new int[n][2];
        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine(), " ");
            list[i][0]=Integer.parseInt(st.nextToken());
            list[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, ((o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        }));

        for(int i  = 0 ; i < n ; i++){
            bw.write(list[i][0] + " " + list[i][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
