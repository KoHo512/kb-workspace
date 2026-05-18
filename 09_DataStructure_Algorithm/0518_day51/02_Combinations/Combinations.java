class Solution {
    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, new ArrayList<>(), n, k);
        return answer;
    }

    private void dfs(int start, List<Integer> path, int n, int k) {
        if (path.size() == k) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(i + 1, path, n, k);
            path.remove(path.size() - 1);
        }
    }
}