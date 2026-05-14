class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    int n, m;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int answer = 0;

        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    answer++;
                    dfs(grid, i, j);
                }
            }
        }

        return answer;
    }

    void dfs(char[][] grid, int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (grid[nr][nc] == '1' && !visited[nr][nc]) {
                    dfs(grid, nr, nc);
                }
            }
        }
    }
}