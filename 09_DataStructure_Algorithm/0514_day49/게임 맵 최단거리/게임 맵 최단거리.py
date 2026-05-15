from collections import deque

def solution(maps):
    n, m = len(maps), len(maps[0])
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    visited = [[False] * m for _ in range(n)]
    queue = deque([(0, 0, 1)])
    
    while queue:
        r, c, dist = queue.popleft()
        
        if r == n - 1 and c == m - 1:
            return dist
        
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            
            if (0 <= nr < n and 0 <= nc < m and not visited[nr][nc] and maps[nr][nc] == 1):
                visited[nr][nc] = True
                queue.append((nr, nc, dist + 1))
        
    return -1