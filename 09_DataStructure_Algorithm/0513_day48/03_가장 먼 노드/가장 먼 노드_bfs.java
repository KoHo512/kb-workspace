import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {        
        List<List<Integer>> graph = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            graph.get(e[0] - 1).add(e[1] - 1);
            graph.get(e[1] - 1).add(e[0] - 1);
        }
        
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        
        int start = 0;
        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    distance[nxt] = distance[cur] + 1;
                    queue.offer(nxt);
                }
            }
        }
        
        int max = distance[start];
        for (int i = start; i < n; i++) {
            if (max < distance[i]) max = distance[i];
        }
        
        int answer = 0;
        for (int d : distance) {
            if (d == max) answer++;
        }
        
        return answer;
    }
}