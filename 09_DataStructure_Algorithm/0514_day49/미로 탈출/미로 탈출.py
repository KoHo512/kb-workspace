from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    def find_start():
        for i in range(n):
            for j in range(m):
                if maps[i][j] == "S":
                    return i, j
    
    sr, sc = find_start()
    distance = 0
        
    # 레버 찾기
    visited = [[False] * m for _ in range(n)]
    queue = deque([(sr, sc, distance)])

    while queue:
        r, c, dist = queue.popleft()
        
        if maps[r][c] == "L":
            sr, sc, distance = r, c, dist
            break
        
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if (0 <= nr < n and 0 <= nc < m and not visited[nr][nc] and maps[nr][nc] != "X"):
                visited[nr][nc] = True
                queue.append((nr, nc, dist + 1))
    else:
        return -1
    
    # 출구 찾기
    visited = [[False] * m for _ in range(n)]
    queue = deque([(sr, sc, distance)])
    
    while queue:
        r, c, dist = queue.popleft()
        
        if maps[r][c] == "E":
            return dist
        
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if (0 <= nr < n and 0 <= nc < m and not visited[nr][nc] and maps[nr][nc] != "X"):
                visited[nr][nc] = True
                queue.append((nr, nc, dist + 1))
                
    return -1