package BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 복습 필요
 * Input1 : M, N
 * Input2 : N개 줄에 보드의 각 행의 상태가 주어짐
 * Output : 지민이가 다시 칠해야 하는 정사각형의 개수
 */
public class B_1018 {
    static char[][] chessBoard;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        chessBoard = new char[m][n];

        for(int i  = 0 ; i < m ; i++){
            String row = br.readLine();
            for(int j = 0 ; j < n ; j++){
                chessBoard[i][j] = row.charAt(j);
            }
        }

        list = new ArrayList<>();

        for(int i = 0 ; i < m-7;i++){
            for(int j = 0 ; j < n-7; j++){
                check(i,j);
            }
        }

        bw.write(Collections.min(list) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void check(int x, int y) {
        char startChar = chessBoard[x][y];
        int count = 0;
        for(int i = x ; i < x+8 ; i++){
            for(int j = y ; j < y+8 ; j++){
                //틀린 문자
                if(chessBoard[i][j] != startChar){
                    count++;
                }
                if(startChar == 'W')
                    startChar = 'B';
                else
                    startChar = 'W';
            }
            if(startChar == 'W')
                startChar = 'B';
            else
                startChar = 'W';
        }
        list.add(Math.min(count,64-count));
    }
}
