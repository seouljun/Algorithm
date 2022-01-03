package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 설탕배달
 * N 킬로그램을 배달해야한다.
 * 봉지는 각 3KG , 5KG가 존재
 * 최대한 적은 봉지를 가져간다.
 * N 킬로그램을 배달 해야할 때, 봉지를 몇개 가져가야 하는가
 *
 * 풀이
 * 5로 나누었을때 나누어 떨어지는 것이 가장 작은 설탕 봉지 수
 * N / 5 && N % 5 의 규칙을 잘 활용한다
 */
public class B_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int modInput = input % 5;
        int divInput = input / 5;
        int count = 0;
        if (input == 4 || input == 7) {
            count = -1;
        } else {
            switch (modInput) {
                case 0:
                    count = divInput;
                    break;
                case 1:
                case 3:
                    count = divInput + 1;
                    break;
                case 2:
                case 4:
                    count = divInput + 2;
                    break;
            }
        }

        System.out.println(count);

        br.close();
    }
}
