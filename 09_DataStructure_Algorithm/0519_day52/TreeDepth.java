import java.util.ArrayDeque;
import java.util.Queue;

public class TreeDepth {
    public static void main(String[] args) {
        int[][] tree = {
                {1, 2},
                {},
                {3, 4},
                {5, 6},
                {},
                {},
                {}
        };

        System.out.println(dfs(0, tree));
        System.out.println(bfs(0, tree));
    }

    // 트리의 max depth 반환
    static int dfs(int root, int[][] tree) {
        int max_depth = -1;

        for (int child : tree[root]) {
            max_depth = Math.max(max_depth, dfs(child, tree));
        }

        max_depth += 1;

        return max_depth;
    }

    static int bfs(int root, int[][] tree) {
        int max_depth = -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{root, 0});

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cur = tmp[0];
            int level = tmp[1];

            max_depth = Math.max(max_depth, level);

            for (int child : tree[cur]) {
                queue.offer(new int[]{child, level + 1});
            }
        }

        return max_depth;
    }
}
