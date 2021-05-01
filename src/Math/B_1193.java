package Math;

import java.io.*;

public class B_1193 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bottom = 0;
        int top = 0;

        int input = Integer.parseInt(br.readLine());

        int count = 0;
        int start = 0;

        while((count+1) * count * 0.5 < input){
            start = (int)(1 + (count+1) * count * 0.5);
            count++;
        }
        //시작점 위 분모 고정
        if(count % 2 == 0){
            //분모
            bottom = count - (input - start);
            //분자
            top = 1 + (input - start);
        } else { //시작점 아래 분자 고정정
            //분모
            bottom = 1 + (input - start);
            //분자
            top = count - (input - start);
        }
        bw.write(top + "/" + bottom + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
