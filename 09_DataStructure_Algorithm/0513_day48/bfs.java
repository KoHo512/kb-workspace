import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class bfs {
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
        // BFS(너비 우선 탐색) - 스택 사용
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        // 시작 노드 예약
        int startNode = 0;
        q.offer(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            // 방문
            int cur = q.poll();
            System.out.println(cur);

            // 다음 노드 예약
            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}
