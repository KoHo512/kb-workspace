def solution(k, dungeons):
    answer = -1
    
    n = len(dungeons)
    visited = [False] * n
    
    def permutations(count, k):
        nonlocal answer
        answer = max(answer, count)
        
        for idx in range(n):
            if not visited[idx] and k >= dungeons[idx][0]:
                visited[idx] = True
                permutations(count + 1, k - dungeons[idx][1])
                visited[idx] = False
    
    permutations(0, k)
        
    return answer