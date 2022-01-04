package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class B_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < n; i++){
            arr[i][2] = 1;
        }
        for(int i = 0 ; i < n; i++){
            for(int j = i+1 ; j < n ; j++){
                if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]){
//                    if(arr[i][2] != 1){
//                        arr[i][2]--;
//                    }
                    if(arr[j][2] != n){
                        arr[j][2]++;
                    }

                }
//                else if(arr[i][0] > arr[j][0] && arr[i][1] < arr[j][1]){
//                    return;
//                }
//                else if(arr[i][0] < arr[j][0] && arr[i][1] > arr[j][1]){
//                    return;
//                }
                else if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    if(arr[i][2] != n)
                        arr[i][2]++;
//                    if(arr[j][2] != 1)
//                        arr[j][2]--;
                }
            }
        }
        for(int i = 0 ; i < n; i++){
            bw.write(arr[i][2] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
