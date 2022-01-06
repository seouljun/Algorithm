package BruteForce;

import java.io.*;

/**
 * 9999까지의 제목을 저장하고 숫자에 맞쳐 출력한다.
 * 위 처럼하지 않았고
 * 주어진 n까지의 666리스트를 생성하여 찾은 횟수가 같을때 끝낸다.
 */
public class B_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(fn(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int fn(int value){
        String start = "666";
        int i = 0;
        int count = 0;
        do {
            i++;
            if (Integer.toString(i).contains(start)) {
                count++;
            }
        } while (value != count);
        return i;
    }
}
