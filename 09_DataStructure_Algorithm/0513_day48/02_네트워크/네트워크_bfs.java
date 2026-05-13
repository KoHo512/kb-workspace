import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                queue.offer(i);
                visited[i] = true;
                
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    
                    for (int nxt = 0; nxt < n; nxt++) {
                        if (!visited[nxt] && computers[cur][nxt] == 1) {
                            queue.offer(nxt);
                            visited[nxt] = true;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}