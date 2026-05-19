import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(nums, new ArrayList<>(), answer);
        return answer;
    }

    static void dfs(int[] nums, List<Integer> cur, List<List<Integer>> answer) {
        if (cur.size() == nums.length) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                dfs(nums, cur, answer);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
