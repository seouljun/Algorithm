package Sort;

import java.io.*;
import java.util.Arrays;

/**
 * 복습
 * 카운팅 정렬
 * O(n)의 속도지만 메모리 차지가 심함
 * 이론참고 : https://st-lab.tistory.com/104
 */
public class B_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] sortedList = new int [n];
        int[] countList;
        //정렬해야 할 배열 생성
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        int max = Arrays.stream(list).max().getAsInt();
        countList = new int[max+1];

        //카운팅 배열 값 삽입
        for (int i = 0; i < n; i++) {
            countList[list[i]] += 1;
        }
        //누계합
        for(int i = 1 ; i < countList.length; i++){
            countList[i] += countList[i-1];
        }

        for(int i = n-1 ; i >= 0 ; i--){
            //값
            countList[list[i]]--;
            sortedList[countList[list[i]]] = list[i];
        }

        for (int j : sortedList) {
            bw.write(j + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
