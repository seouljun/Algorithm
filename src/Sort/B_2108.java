package Sort;

import java.io.*;
import java.util.*;

/**
 * 더 좋은 방법이 있을듯 복습
 * Input1 : N 개수
 * Input2 : N개의 정수
 * Output : 산술평균
 * Output2 : 중앙값
 * Output3 : 최빈값 여러개일 경우 두번째로 작은 값
 * Output4 : 최댓값과 최솟값의 차이
 */
public class B_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        // 산술 평균
        bw.write(Avg(list) + "\n");
        // 중앙값
        bw.write(Middle(list) + "\n");
        // 최빈값
        bw.write(Mode(list)+"\n");
        // 범위
        bw.write(Range(list) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int Range(int[] list) {
        return list[list.length-1]-list[0];
    }

    static int Avg(int[] list) {
        double sum = 0;
        for (double j : list) {
            sum += j;
        }
        return (int) Math.round(sum / list.length);
    }

    static int Middle(int[] list) {
        Arrays.sort(list);
        return list[list.length / 2];
    }

    static int Mode(int[] list) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i : list) {
            map.put(i, 0);
        }

        for (int i : list) {
            if (map.get(i) != null) {
                map.put(i, map.get(i) + 1);
            }
        }

        List<Map.Entry<Integer,Integer>> List = new ArrayList<>(map.entrySet());
        List.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int max = List.get(0).getValue();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> top : List){
            if(top.getValue().equals(max)){
                arrayList.add(top.getKey());
            }
        }
        Collections.sort(arrayList);
        if(arrayList.size() == 1)
            return arrayList.get(0);
        else
            return arrayList.get(1);
    }
}
