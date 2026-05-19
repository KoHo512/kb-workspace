def solution(n, wires):
    answer = n
    
    def dfs(cur):
        visited[cur] = True
        count = 1
        
        for nxt in graph[cur]:
            if not visited[nxt]:
                count += dfs(nxt)
        
        return count
        
    for i in range(n - 1):
        graph = [[] for _ in range(n + 1)]
        visited = [False] * (n + 1)
        for j in range(n - 1):
            if j != i:
                graph[wires[j][0]].append(wires[j][1])
                graph[wires[j][1]].append(wires[j][0])
        
        answer = min(answer, abs(dfs(wires[i][0]) - dfs(wires[i][1])))
    
    return answer

##
#
# 해설집 참고

def solution(n, wires):
    graph = [[] for _ in range(n + 1)]
    
    for w1, w2 in wires:
        graph[w1].append(w2)
        graph[w2].append(w1)
        
    visited = [False] * (n + 1)
    subtrees = [[] for _ in range(n + 1)]
    
    def dfs(cur):
        visited[cur] = True
        subtrees[cur] = 1
        
        for nxt in graph[cur]:
            if not visited[nxt]:
                dfs(nxt)
                subtrees[cur] += subtrees[nxt]
                
    dfs(1)
    
    answer = float("INF")
    for i in range(2, n + 1):
        answer = min(answer, abs(n - 2 * subtrees[i]))
    
    return answer