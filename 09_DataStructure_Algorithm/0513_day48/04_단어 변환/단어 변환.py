from collections import deque

def solution(begin, target, words):
    n = len(words)
    visited = [False] * n
    queue = deque([])
    
    def canChange(word1, word2):
        count = 0
        
        for i in range(len(word1)):
            if word1[i] != word2[i]:
                count += 1
        
        return count == 1
    
    queue.append([begin, 0])
    
    while queue:
        cur, dist = queue.popleft()
        
        if cur == target:
            return dist
        
        for i in range(n):
            if not visited[i] and canChange(cur, words[i]):
                visited[i] = True
                queue.append([words[i], dist + 1])
    
    return 0