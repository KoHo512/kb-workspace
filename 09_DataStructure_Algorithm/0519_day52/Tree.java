class Tree {
    public static void main(String[] args) {
        int[][] tree = {
                {1, 2},
                {},
                {3, 4},
                {},
                {}
        };

        System.out.println(dfs(0, tree));
    }

    static int dfs(int root, int[][] tree) {
        // root를 루트로 가지고 있는 트리의 전체 노드 개수 반환
        int answer =  1;
//        // 노드 총합 구하려면
//        int answer = root;

        for (int child : tree[root]) {
            answer += dfs(child, tree);
        }

        return answer;
    }
}