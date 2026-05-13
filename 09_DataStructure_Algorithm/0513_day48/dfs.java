import java.util.ArrayList;
import java.util.List;

public class dfs {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 4},
                {1, 3},
                {2, 4},
                {3, 4}
        };

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        System.out.println(graph);
        // [[1, 2, 4], [0, 3], [0, 4], [1, 4], [0, 2, 3]]

        //
        //
        // DFS(깊이 우선 탐색) - 재귀 사용
        boolean[] visited2 = new boolean[n];
        dfs(0, graph, visited2);
    }

    static void dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        // 방문
        visited[cur] = true;
        System.out.println(cur);

        // 다음 노드 dfs 실행
        for (int nxt : graph.get(cur)) {
            if (!visited[nxt]) {
                dfs(nxt, graph, visited);
            }
        }
    }
}
