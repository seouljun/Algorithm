package Math;

import java.io.*;
import java.util.StringTokenizer;

public class B_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (n > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            bw.write(getCount(x1, x2, y1, y2, r1, r2) + "\n");
            n--;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int getCount(int x1, int x2, int y1, int y2, int r1, int r2) {
        //점과 점사이의 거리
        double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
        //점,거리 모두 동일할때 -> 무한한 접점
        if (x1 == x2 && y1 == y2 && r1 == r2)
            return -1;
        //두 점사이 거리가 각 반지름의 합보다 크다면 만나지 않는다(아에 떨어져 있음)
        else if (distance > Math.pow(r1 + r2, 2))
            return 0;
        //두 점사이 거리가 각 반지름의 차이보다 작다면 만나지 않는다(원안의 원)
        else if (distance < Math.pow(r1 - r2, 2))
            return 0;
        //두 점사이의 거리가 각 원의 반지름의 합과 같다면 한점에서 만난다(오른쪽 왼쪽 등등 붙어있는 형태)
        else if (distance == Math.pow(r1 + r2, 2))
            return 1;
        //두 점사이의 거리가 각 원의 반지름의 차와 같다면 한점에서 만난다(원 안에 원으로 붙어있는 형태)
        else if (distance == Math.pow(r1 - r2, 2))
            return 1;
        //나머지는 접점이 2개
        else
            return 2;
    }
}
