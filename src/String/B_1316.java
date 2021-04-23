package String;

import java.io.*;
import java.util.StringTokenizer;

public class B_1316 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(br.readLine());
        int counta = count;
        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            int index = 0;
            boolean jud = true;
            for(int j = 0 ; j < input.length(); j++){
                int temp = 0;

                for(char data : input.toCharArray()){
                    if(input.charAt(j) == data){
                        if(temp >= index + 2){
                            counta--;
                            jud = false;
                            break;
                        }
                        index = temp;
                    }
                    temp++;
                }

                if(!jud){
                    break;
                }
            }
        }
        bw.write(counta+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
