package programmers;
import java.util.*;

public class Question_5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] temp = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution.solution(6, temp));
    }

    static class Solution {
        public int solution(int n, int[][] edge) {
            // 그래프 생성
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] e : edge) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }

            // 최단 거리 저장 배열 (방문하지 않은 노드는 -1)
            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);
            dist[1] = 0;

            // BFS 탐색 (Queue 사용)
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbor : graph.get(node)) {
                    if (dist[neighbor] == -1) { // 방문하지 않은 노드만 처리
                        dist[neighbor] = dist[node] + 1;
                        queue.add(neighbor);
                    }
                }
            }

            // 최대 거리 찾기
            int maxDist = Arrays.stream(dist).max().getAsInt();

            // 최대 거리 노드 개수 세기
            int answer = 0;
            for (int d : dist) {
                if (d == maxDist) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
