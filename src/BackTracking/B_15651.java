package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class B_15651 {
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];       //출력할 array
        visit = new boolean[n]; //중복 판별 배열
        dfs(n,m,0);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int n, int m, int depth) throws IOException {
        if(m == depth){
            for(int x : arr)
                bw.write(x + " ");
            bw.write("\n");
            return;
        }
        for(int i = 0; i < n ; i++){
            arr[depth] = i+1;
            dfs(n,m,depth + 1);
        }
    }
}
