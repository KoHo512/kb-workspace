class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    int dfs(int[] numbers, int target, int idx, int sum) {
        int count = 0;
        
        if (idx == numbers.length) {
            return target == sum ? 1 : 0;
        }
        
        count += dfs(numbers, target, idx + 1, sum + numbers[idx]);
        count += dfs(numbers, target, idx + 1, sum - numbers[idx]);
        
        return count;
    }
}