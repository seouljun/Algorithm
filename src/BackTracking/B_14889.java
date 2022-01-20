package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class B_14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static boolean[] judge;
    static int startTeam = 0;
    static int linkTeam = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        judge = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        doFind(n,1, 0,1);
    }

    private static void doFind(int num, int count, int x, int y) {
        if(num == 0){

            return;
        }
        if(count % 2 != 0){
            startTeam++;
        }else {
            linkTeam++;
        }
        for(int i = 0 ; i < num; i++){

        }

    }

    private static int cal(int i, int j){
        return arr[i][j] + arr[j][i];
    }
}
