// 완전 탐색으로 풀기
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for (int k = 0; k < n - 1; k++) {
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<>()) ;
            }
            for (int j = 0; j < n - 1; j++) {
                if (k == j) continue;
                tree.get(wires[j][0] - 1).add(wires[j][1] - 1);
                tree.get(wires[j][1] - 1).add(wires[j][0] - 1);
            }
            
            int count = dfs(0, tree, new boolean[n]);
            answer = Math.min(answer, Math.abs(2 * count - n));
        }
        
        return answer;
    }
    
    int dfs(int cur, List<List<Integer>> tree, boolean[] visited) {
        int count = 1;
        visited[cur] = true;
        
        for (int child : tree.get(cur)) {
            if (!visited[child]) {
                count += dfs(child, tree, visited);
            }
        }
    
        return count;
    }
}
// => O(n²)

// DFS
import java.util.*;

class Solution {
    int minDiff;
    public int solution(int n, int[][] wires) {
        minDiff = n;
        
        // 간선리스트 => 인접리스트 변환
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>()) ;
        }
        for (int[] e : wires) {
            tree.get(e[0] - 1).add(e[1] - 1);
            tree.get(e[1] - 1).add(e[0] - 1);
        }
        
        dfs(0, tree, new boolean[n]);
        
        return minDiff;
    }
    
    // 노드의 개수를 세면서 차이값 계산해서 업데이트
    int dfs(int root, List<List<Integer>> tree, boolean[] visited) {
        visited[root] = true;
        int count = 1;
        
        for (int child : tree.get(root)) {
            if (!visited[child]) {
                count += dfs(child, tree, visited);
            }
        }
        
        int cnt1 = count;
        int cnt2 = tree.size() - count;
        
        minDiff = Math.min(minDiff, Math.abs(cnt1 - cnt2));
        
        return count;
    }
}