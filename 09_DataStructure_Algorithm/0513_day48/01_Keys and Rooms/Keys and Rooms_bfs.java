import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque();

        int startNode = 0;
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();

            for (int nxt : rooms.get(cur)) {
                if (!visited[nxt]) {
                    queue.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}