import java.util.Scanner;

public class Main {
    static long[][] d;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n+1][10];
        long count = 0;
        for(int i = 0 ; i <=9 ; i++){
            d[1][i] = 1L;
        }
        for(int i = 1; i <=9 ; i++){
            count += doCal(n,i);
        }
        System.out.println(count % 1000000000);
    }

    private static long doCal(int n, int value) {
        if(n == 1){
            return d[n][value];
        }
        if(d[n][value] != 0) return d[n][value];

        if(value == 0){
            d[n][value] = doCal(n-1,1);
        }
        else if(value == 9){
            d[n][value] = doCal(n-1,8);
        }
        else {
            d[n][value] = doCal(n-1,value-1) + doCal(n-1,value+1);
        }
        return d[n][value] % 1000000000;
    }
}