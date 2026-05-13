import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        
        // 인접리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (canChange(words[i], words[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        // BFS
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (canChange(begin, words[i])) {
                visited[i] = true;
                queue.offer(new int[]{i, 1});
            }
        }
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cur = tmp[0];
            int dist = tmp[1];
            
            if (words[cur].equals(target)) return dist;
            
            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    queue.offer(new int[]{nxt, dist + 1});
                } 
            }
        }
        
        return 0;
    }
    
    boolean canChange(String word1, String word2) {
        int diff = 0;
        
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diff++;
            
            if (diff > 1) return false;
        }
        
        return true;
    }
}