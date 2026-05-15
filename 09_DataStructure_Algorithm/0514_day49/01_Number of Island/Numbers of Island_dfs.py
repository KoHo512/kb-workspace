class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        answer = 0
        n = len(grid)
        m = len(grid[0])
        dr = [-1, 1, 0, 0]
        dc = [0, 0, -1, 1]
        visited = [[False] * m for _ in range(n)]
        
        
        def dfs(x, y):
            visited[x][y] = True

            for i in range(4):
                nx = x + dr[i]
                ny = y + dc[i]

                if (0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and grid[nx][ny] == "1"):
                    dfs(nx, ny)

        for i in range(n):
            for j in range(m):
                if not visited[i][j] and grid[i][j] == "1":
                    answer += 1
                    dfs(i, j)
        
        return answer