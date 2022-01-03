package Math;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 두 정수 A, B 입력 후 A+B를 출력
 *
 * 풀이
 * Big Int 사용
 */
public class B_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        System.out.println(A.add(B));
        br.close();
    }
}
