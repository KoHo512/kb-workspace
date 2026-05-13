class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    void dfs(int cur, List<List<Integer>> rooms, boolean[] visited) {
        visited[cur] = true;

        for (int nxt : rooms.get(cur)) {
            if (!visited[nxt]) {
                dfs(nxt, rooms, visited);
            }
        }
    }
}