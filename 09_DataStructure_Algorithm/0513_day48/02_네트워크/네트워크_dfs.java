import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, visited);
            }
        }
        
        return answer;
    }
    
    void dfs(int cur, int[][] computers, boolean[] visited) {
        visited[cur] = true;
        
        for (int nxt = 0; nxt < computers[cur].length; nxt++) {
            if (!visited[nxt] && computers[cur][nxt] == 1) {
                dfs(nxt, computers, visited);
            }
        }
    }
}