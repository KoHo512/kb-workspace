class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(new ArrayList<>(), nums, answer);
        return answer;
    }

    private void dfs(List<Integer> cur, int[] nums, List<List<Integer>> answer) {
        if (cur.size() == nums.length) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for (int num : nums) {
            if (!cur.contains(num)) {
                cur.add(num);
                dfs(cur, nums, answer);
                cur.remove(cur.size() - 1);
            }
        }
    }
}