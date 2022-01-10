package BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백트래킹 첫번째
 * input n , m
 * 1~n까지 자연수 중 중복 없이 M개를 고른 수열
 * 재귀 사용 (DFS)
 */
public class B_15649 {
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];     //방문노드 확인을 위한 bool 배열
        arr = new int[m];           //m개의 수열을 담을 배열
        dfs(n,m,0);           //탐색 함수
        br.close();
    }
    /*
    1 ~ n : 범위
    m == 횟수
     */
    static void dfs(int n, int m, int depth){
        //수열의 필요한 개수 m과 깊이가 같으면 출력
        if(m == depth){
            for(int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        //노드역할
        for(int i = 0 ; i < n ; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i + 1;
                //dfs이기 때문에 끝점까지 찍는다.
                dfs(n,m,depth+1);
                visit[i] = false;
            }
        }
    }
}

