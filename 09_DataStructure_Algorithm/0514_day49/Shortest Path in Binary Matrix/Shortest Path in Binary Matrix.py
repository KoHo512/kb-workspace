from collections import deque

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dr = [-1, 1, 0, 0, -1, -1, 1, 1]
        dc = [0, 0, -1, 1, -1, 1, -1, 1]
        visited = [[False] * n  for _ in range(n)]

        if grid[0][0] == 0:
            visited[0][0] = True
            queue = deque([(0, 0, 1)])
        else:
            return -1

        while queue:
            r, c, dist = queue.popleft()

            if r == n - 1 and c == n - 1:
                return dist

            for i in range(8):
                nr = r + dr[i]
                nc = c + dc[i]

                if (0 <= nr < n and 0 <= nc < n and not visited[nr][nc] and grid[nr][nc] == 0):
                    visited[nr][nc] = True
                    queue.append((nr, nc, dist + 1))
        
        return -1