class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n, m = len(board), len(board[0])
        dr = [-1, 1, 0, 0]
        dc = [0, 0, -1, 1]

        visited = [[False] * m for _ in range(n)]

        def dfs(r, c, idx):
            if idx == len(word) - 1:
                return True

            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]

                if 0 <= nr < n and 0 <= nc < m and not visited[nr][nc]:
                    if board[nr][nc] == word[idx + 1]:
                        visited[nr][nc] = True
                        if dfs(nr, nc, idx + 1):
                            return True
                        visited[nr][nc] = False
            
            return False

        for i in range(n):
            for j in range(m):
                if board[i][j] == word[0]:
                    visited[i][j] = True
                    if dfs(i, j, 0):
                        return True
                    visited[i][j] = False
        
        return False
