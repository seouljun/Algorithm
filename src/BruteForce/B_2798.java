package BruteForce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * New 블랙잭
 * Input Line 1 : 카드 개수(N), 숫자(M)
 * Input Line 2 : 카드에 적힌 숫자
 * Output : M을 넘지 않으면서 M과 가장 가까운 숫자
 * Point 3장을 선택
 */
public class B_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < n ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int sum;
        for(int i = 0; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                for(int k = j+1 ; k < n ; k++){
                    sum = numbers[i] + numbers[j] + numbers[k];
                    if(m-sum >= 0 && max < sum)
                        max = sum;
                }
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
