/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int answer = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);

        return answer;
    }

    void dfs(TreeNode node, int depth) {
        if (node == null) return;

        answer = Math.max(answer, depth);

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}

/** **********
 * 수업 풀이
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    int dfs(TreeNode root) {
        int max_depth = 0;
        
        if (root.left != null) {
            max_depth = Math.max(max_depth, dfs(root.left));
        }

        if (root.right != null) {
            max_depth = Math.max(max_depth, dfs(root.right));
        }

        return max_depth + 1;
    }
}