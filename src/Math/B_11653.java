package Math;


import java.io.*;
import java.util.ArrayList;

/**
 * 소인수 분해
 */
public class B_11653 {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(isPrime(n))
            bw.write(n + "\n");
        else if(n != 1){
            getValue(n).forEach(x-> {
                try {
                    bw.write(x+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        bw.flush();
        bw.close();
        br.close();

    }
    static Boolean isPrime(int value){
        boolean isPrime = true;
        if(value == 1)
            return false;
        else{
            for(int i = 2; i <= Math.sqrt(value); i++){
                if (value % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        }
    }
    static ArrayList<Integer> getValue(int value){
        if(value == 1)
            return null;
        else{
            for(int i = 2; i <= value; i++){
                if(value % i == 0){
                    list.add(i);
                    getValue(value/i);
                    break;
                }
            }
            return list;
        }
    }
}
