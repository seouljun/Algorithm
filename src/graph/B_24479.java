package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * INPUT
 * 첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.
 *
 * 다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.
 */
public class B_24479
{
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visit;
    private static Integer[] result;
    private static int count = 1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ");

        // node
        int n = Integer.parseInt(stringTokenizer.nextToken());
        // edge
        int m = Integer.parseInt(stringTokenizer.nextToken());
        // start
        int r = Integer.parseInt(stringTokenizer.nextToken());

        result = new Integer[n+1];
        visit = new boolean[n+1];

        for (int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }


        for(int i = 0; i < m; i++)
        {
            String line = br.readLine();
            stringTokenizer = new StringTokenizer(line, " ");
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (ArrayList<Integer> integers : graph)
        {
            Collections.sort(integers);
        }

        dfs(r);

        for (int i = 1; i < result.length; i++)
        {
            bw.write((result[i] == null ? 0 : result[i]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int node)
    {
        if (visit[node])
        {

        }
        else
        {
            result[node] = count;
        }
        
        //다음은 어디로 갈껀지 인접 노드 검색
        ArrayList<Integer> adNodes = graph.get(node);

        for (int i = 0; i < adNodes.size(); i++)
        {
            Integer vertex = adNodes.get(i);
            if (vertex != null)
            {
                if (!visit[vertex])
                {
                    visit[vertex] = true;
                    count++;
                    dfs(vertex);
                }
            }
        }
    }
}
