package Sort;

import java.io.*;

public class B_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] arr2;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr2 = arr;
//        selectionSort(arr);

        for (int i = 0; i < n; i++) {
//            bw.write(selectionSort(arr)[i] + "\n");
            bw.write(insertSort(arr)[i] + "\n");
        }
        bw.write("===============\n");
        for (int i = 0; i < n; i++) {
            bw.write(BubbleSort(arr2)[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //선택정렬
    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    //삽입정렬
    static int[] insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            // 타겟 넘버
            int target = arr[i];

            int j = i - 1;

            // 타겟이 이전 원소보다 크기 전 까지 반복
            while(j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];	// 이전 원소를 한 칸씩 뒤로 미룬다.
                j--;
            }

            /*
             * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
             * 타겟 원소는 j번째 원소 뒤에 와야한다.
             * 그러므로 타겟은 j + 1 에 위치하게 된다.
             */
            arr[j + 1] = target;
        }
        return arr;
    }
    //버블정렬
    static int[] BubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1; i++){
            for(int j = i+1; j < arr.length ; j++){
                if(arr[i] > arr[j]){
                    int value = arr[j];
                    arr[j] = arr[i];
                    arr[i] = value;
                }
            }
        }
        return arr;
    }
}
