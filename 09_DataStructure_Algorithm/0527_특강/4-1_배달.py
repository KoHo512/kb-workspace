# https://school.programmers.co.kr/learn/courses/30/lessons/12978?language=python3

def solution(N, road, K):
    answer = [float("INF")] * N
    
    graph = [[float("INF")] * N for _ in range(N)]
    for n1, n2, k in road:
        graph[n1 - 1][n2 - 1] = min(graph[n1 - 1][n2 - 1], k)
        graph[n2 - 1][n1 - 1] = min(graph[n2 - 1][n1 - 1], k)

    def dfs(n):
        for i in range(N):
            if i != n and graph[n][i] != float("INF"):
                if answer[i] >= answer[n] + graph[n][i]:
                    answer[i] = answer[n] + graph[n][i]
                    dfs(i)
    
    answer[0] = 0
    dfs(0)
    
    return len([a for a in answer if a <= K])


## 강의 코드
def solution(N, road, K):
    answer = 0

    # 기본 거리값을 가장 큰 값으로 세팅
    di = [float('inf')] * (N + 1)
    
    g = [[] for i in range(N + 1)]
    
    for a, b, c in road:
        g[a].append([b, c]);
        g[b].append([a, c]);
        
    q = []
    
    # 1번 마을에서 시작
    di[1] = 0
    q.append([1, 0])
    
    while q:
        now, now_di = q.pop(0)
        for nex, nex_di in g[now]:
            if di[nex] > di[now] + nex_di:
                di[nex] = di[now] + nex_di
                q.append([nex, di[nex]])

    for i in di:
        if K >= i:
            answer += 1
            
    return answer

# => q에서 now_di를 사용 안 하는데 왜 같이 저장하지..? 빼도 문제 없이 동작함..