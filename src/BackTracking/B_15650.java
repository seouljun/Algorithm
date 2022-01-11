package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15650 {
    static int[] array;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];

        Backtracking(1, 0);
    }

    private static void Backtracking(int at, int depth) {
        if(m == depth){
            for(int x : array)
                System.out.print(x + " ");
            System.out.println();
            return;
        }
        for(int i = at ; i <= n ; i++){
            array[depth] = i;
            Backtracking(i+1,depth+1);
        }
    }
}
