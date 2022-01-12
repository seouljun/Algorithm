package BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2580 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int endPoint;
    static int[][] array;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //스도쿠 배열생성
        array = new int[9][9];
        //스도쿠 입력받음 && 0 위치 리스트에 입력
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] == 0) {
                    list.add(i + "," + j);
                }
            }
        }
        endPoint = list.size();
        sudoku(0);
    }

    private static void sudoku(int depth) throws IOException {
        if (depth == endPoint) {
            for (int[] arr : array) {
                for (int value : arr) {
                    bw.write(value + " ");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            br.close();
            System.exit(0);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            String[] point = list.get(depth).split(",");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            if (isPossible(i, x, y)) {
                array[x][y] = i;
                sudoku(depth + 1);
            }
            array[x][y] = 0;

        }
    }

    private static boolean isPossible(int value, int x, int y) {
        if(!locale(value, x,y)){
            return false;
        }else{
            for (int i = 0; i < 9; i++) {
                if (value == array[x][i]) {           //가로
                    return false;
                } else if (value == array[i][y]) {    //세로
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean locale(int value, int x, int y){
        int startX = 0;
        int startY = 0;
        if(x > 2){
            startX = x >= 6 ? 6 : 3;
        }
        if(y > 2){
            startY = y >= 6 ? 6 : 3;
        }
        for(int i = startX ; i < startX+3 ; i++){
            for(int j = startY ; j < startY+3 ; j++){
                if(value == array[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
