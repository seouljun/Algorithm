package Sort;

import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];
        StringTokenizer st;
        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine(), " ");
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list,((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0]-o2[0];
            }else{
                return o1[1]-o2[1];
            }
        }));
        for(int i = 0 ; i < n ; i++){
            bw.write(list[i][0] + " " + list[i][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

