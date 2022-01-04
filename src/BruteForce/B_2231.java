package BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 분해합 생성자 문제
 * Input : 자연수 N
 * Output : N의 가장 작은 생성자 출력 / 없을 경우 0 출력
 */
public class B_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        int N = Integer.parseInt(n);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= 1000000 ; i ++){
            int makers = makers(Integer.toString(i));
            if(makers == N){
                list.add(i);
            }
        }
        if(list.isEmpty()){
            bw.write(0 + "\n");
        }else{
            bw.write(Collections.min(list) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int makers(String value){
        int N = Integer.parseInt(value);
        int length = value.toCharArray().length;
        for(int i = 0 ; i < length ; i++){
            N += value.toCharArray()[i] - '0';
        }
        return N;
    }
}
