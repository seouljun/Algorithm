package Recursion;

import java.io.*;

public class B_2447 {
    static String[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        //별 찍을 배열 생성
        arr = new String[n][n];

        makeStar(n, 0, 0, false);
        printStar(arr,n, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    static void makeStar(int value, int x, int y, boolean isBlank) {
        //공백
        if (isBlank) {
            for (int i = x; i < x + value; i++) {
                for (int j = y; j < y + value; j++) {
                    arr[i][j] = " ";
                }
            }
            return;
        }


        //별
        if (value == 1) {
            arr[x][y] = "*";
            return;
        }

        int size = value / 3;
        int count = 0;
        for (int i = x; i < x+value; i+=size) {
            for (int j = y; j < y+value; j+=size) {
                count++;
                if (count == 5) {
                    makeStar(size, i, j, true);
                } else {
                    makeStar(size, i, j, false);
                }
            }
        }
    }
    static void printStar(String[][] arr, int value, BufferedWriter bw) throws IOException {
        for(int i = 0 ; i < value ; i++){
            for(int j = 0 ; j < value ; j++){
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }

    }
}
