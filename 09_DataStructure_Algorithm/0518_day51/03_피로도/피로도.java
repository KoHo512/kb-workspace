class Solution {
    int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        
        dfs(k, dungeons, new boolean[dungeons.length], 0);
        
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(count, answer);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}