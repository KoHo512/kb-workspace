from collections import deque

def solution(n, edge):
    graph = [[] for _ in range(n)]
    
    for e in edge:
        e1, e2 = e
        graph[e1 - 1].append(e2 - 1)
        graph[e2 - 1].append(e1 - 1)
        
    visited = [-1] * n
    
    start = 0
    queue = deque([start])
    visited[start] = 0
    
    while queue:
        cur = queue.popleft()
        
        for nxt in graph[cur]:
            if visited[nxt] == -1:
                visited[nxt] = visited[cur] + 1
                queue.append(nxt)
    
    return visited.count(max(visited))