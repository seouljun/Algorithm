package BackTracking;

import java.io.*;

public class B_9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] array;
    static int count = 0;
    static int n;

    public static void main(String[] arg) throws IOException {
        n = Integer.parseInt(br.readLine());
        /*
        index : 열
        value : 행
         */
        array = new int[n];

        dfs(0);
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int column) {
        /*
        퀸(Queen)은 상, 하, 좌, 우, 대각선 가능
         */
        if(column == n){
            count++;
            return;
        }
        for(int i = 0 ; i < n ; i++){
            array[column] = i;
            if(isAvailable(i, column)){
                dfs(column + 1);
            }
        }

    }
    private static boolean isAvailable(int row, int column){
        for(int i = 0 ; i < column; i++){
            if(row == array[i]){
                return false;
            }
            else if(Math.abs(column-i) == Math.abs(array[column] - array[i])){
                return false;
            }
        }
        return true;
    }


}


