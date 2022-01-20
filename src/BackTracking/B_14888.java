package BackTracking;

import java.io.*;
import java.util.*;

/**
 * 연산자 끼워넣기
 * input 1 : 수의 개수
 * input 2 : 숫자
 * input 3 : 연산자 개수
 * output 1 : 연산 최대값
 * output 2 : 연산 최소값
 */
public class B_14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] operator = new int[4];
    static int[] numbers;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        doFunction(numbers[0], 1, Arrays.stream(operator).sum());
        bw.write(Collections.max(list) + "\n");
        bw.write(Collections.min(list) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void doFunction(int result, int order, int depth) {
        if (depth == 0) {
            list.add(result);
            return;
        }
        for (int j = 0; j < 4; j++) {
            if (operator[j] != 0) {
                int sum = doCal(j, result, numbers[order]);
                operator[j]--;
                doFunction(sum, order + 1, depth - 1);
                operator[j]++;
            }
        }
    }

    private static int doCal(int operator, int x, int y) {
        switch (operator) {
            case 0:
                return x + y;
            case 1:
                return x - y;
            case 2:
                return x * y;
            case 3:
                return x / y;
        }
        return 0;
    }
}

