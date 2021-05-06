package Math;

import java.io.*;

/**
 * 부녀회장이 될테야
 * 수학적으로 접근이 힘들어 k층 n호 까지의 케이스를 생성하여 접근
 * 추후 보완 필요
 */
public class B_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        for (int z = 0; z < cnt; z++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] house = new int[k+1][n+1];


            for(int i = 0 ; i <= k ; i++){
                for(int j = 1 ; j < n+1 ; j++){
                    if(i == 0)
                        house[i][j] = j;
                    else{
                        house[i][j] = 0;
                        for(int c = 1 ; c <= j ; c++)
                            house[i][j] += house[i-1][c];
                    }
                }
            }
            bw.write(house[k][n] + "\n");

        }
        bw.flush();
        br.close();
    }
}

