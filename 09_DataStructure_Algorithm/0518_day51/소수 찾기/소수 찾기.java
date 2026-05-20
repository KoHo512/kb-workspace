import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        // nP1, nP2, ... nPn : 모든 경우의 수 나열
        Set<Integer> candidates = new HashSet<>();
        permute(numbers, new boolean[numbers.length()], new StringBuilder(), candidates);
        
        for (int num : candidates) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    void permute(String numbers, boolean[] visited, StringBuilder cur, Set<Integer> candidates) {
        if (cur.length() > 0) {
            candidates.add(Integer.parseInt(cur.toString()));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                cur.append(numbers.charAt(i));
                visited[i] = true;
                permute(numbers, visited, cur, candidates);
                visited[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
    
    boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}