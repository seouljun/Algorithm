package Math;

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 우주
 * K광년 이동하기 위해서는 k-1, k, k+1 이동가능
 * y지점 까지 이동하는데 y지점 도착 바로 직전 이동거리는 반드시 1광년으로 한다.
 * x지점부터 y지점 까지 이동하는 최소 거리를 구하시오
 * <p>
 * 풀이
 * 실패
 */
public class B_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        for (int range = 0; range < cnt; range++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long distance = (y - 1) - x;
            long count;
            if (distance == 0) {
                count = 1;
            } else {
                count = distance / 2 + 2;
            }


//            BigInteger x = new BigInteger(st.nextToken());
//            BigInteger y = new BigInteger(st.nextToken());
//
//
//            BigInteger count;
//            BigInteger distance = y.subtract(BigInteger.valueOf(1)).subtract(x);
//            if (distance.compareTo(BigInteger.valueOf(1)) == -1) {
//                count = BigInteger.valueOf(1);
//            } else if (distance.compareTo(BigInteger.valueOf(1)) == 0) {
//                count = BigInteger.valueOf(2);
//            } else {
//                count = distance.divide(BigInteger.valueOf(2)).add(BigInteger.valueOf(2)); //distance / 2 + 2;
//            }

            bw.write(count + "\n");
        }
        bw.flush();
        br.close();
    }
}
