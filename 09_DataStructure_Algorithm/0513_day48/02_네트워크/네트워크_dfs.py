def solution(n, computers):
    answer = 0
    visited = [False] * n
    
    def dfs(cur):
        visited[cur] = True
        
        for nxt in range(n):
            if not visited[nxt] and computers[cur][nxt] == 1:
                dfs(nxt)
    
    for i in range(n):
        if not visited[i]:
            answer += 1
            dfs(i)
    
    return answer