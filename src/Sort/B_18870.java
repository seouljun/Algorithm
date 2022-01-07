package Sort;

import java.io.*;
import java.util.*;

public class B_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] numList = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i ++){
            numList[i] = Integer.parseInt(st.nextToken());
            set.add(numList[i]);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Map<Integer,Integer> map = new HashMap<>();

        Collections.sort(list);

        int value = 0;
        for(Integer x : list){
            map.put(x,value);
            value++;
        }
        for(int x : numList)
            bw.write(map.get(x) + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
/*
시간 초과 코드
package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i ++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int[] distinctList = Arrays.stream(list).distinct().toArray();

        Arrays.sort(distinctList);

        for(int i = 0 ; i < n ; i++){
            int point = 0;
            for(int j = 0 ; j < distinctList.length; j++){
                if(list[i] == distinctList[j]){
                    point = j;
                    break;
                }
            }
            bw.write(point + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

 */