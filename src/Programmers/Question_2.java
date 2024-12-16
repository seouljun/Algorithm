package Programmers;

import java.util.ArrayList;
import java.util.List;

/*
3진법 뒤집기
 */
public class Question_2 {

    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }

    public static int solution(int n) {
        int answer = 0;

        List<Integer> thirdList = new ArrayList<>();
        getThird(n, thirdList);

        int size = thirdList.size();
        int[] arr = new int[size];

        for (int i = 0; i < thirdList.size(); i++) {
            arr[i] = thirdList.get(i);
        }


        answer = get(arr);

        return answer;
    }

    public static void getThird(int n, List<Integer> list) {
        int i = n / 3;
        list.add(n % 3);
        if (i > 0) {
            getThird(i, list);
        }
    }

    public static int get(int[] arr) {
        int answer = 0;
        for (int i = arr.length; i > 0; i--) {
            int num = arr[i-1];
            double v = num * Math.pow(3, arr.length - i);
            answer += v;
        }
        return answer;
    }
}
