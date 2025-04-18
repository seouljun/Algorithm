package programmers;

import java.util.*;

/**
 * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
 * 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
 * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
 * *
 * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
 */
public class Question_4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] temp = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution.solution(6, temp));
    }
    static class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;

            Map<Integer, List<Integer>> map = new HashMap<>();

            // List를 이용해 인접 항목 정리
            for (int i = 0; i < edge.length; i++)
            {
                // 각각의 list를 가져옴
                List<Integer> list1 = map.get(edge[i][0]) == null ? new ArrayList<>() : map.get(edge[i][0]);
                List<Integer> list2 = map.get(edge[i][1]) == null ? new ArrayList<>() : map.get(edge[i][1]);

                // 각각 인접 데이터 추가
                list1.add(edge[i][1]);
                list2.add(edge[i][0]);

                // map put
                map.put(edge[i][0], list1);
                map.put(edge[i][1], list2);
            }
            Map<Integer, Integer> memo = new HashMap<>();
            memo.put(1, 0);
            Map<Integer, Integer> integerMap = fn2(1, map, memo, 1, 0);

            int max = 0;
            Set<Integer> integerSet = integerMap.keySet();
            for (Integer key : integerSet) {
                Integer value = integerMap.get(key);
                if (max == value)
                {
                    answer++;
                }
                if (max < value)
                {
                    max = value;
                    answer = 1;
                }
            }
            return answer;
        }

        public Map<Integer, Integer> fn2(int idx, Map<Integer, List<Integer>> nodeMap, Map<Integer, Integer> memo, int length, int before)
        {
            List<Integer> neighborList = nodeMap.get(idx);

            if(neighborList != null)
            {
                for (Integer node : neighborList)
                {
                    if (node == before)
                    {
                        continue;
                    }

                    Integer maxLength = memo.get(node);

                    if (maxLength != null)
                    {
                        if (maxLength > length)
                        {
                            memo.put(node, length);
                            fn2(node, nodeMap, memo, length + 1, idx);
                        }
                    }
                    else
                    {
                        memo.put(node, length);
                        fn2(node, nodeMap, memo, length + 1, idx);
                    }
                }
            }
            return memo;
        }
    }
}
