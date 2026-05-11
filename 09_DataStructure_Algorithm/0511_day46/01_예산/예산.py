def solution(d, budget):
    d.sort()
    total = 0
    
    for i in range(len(d)):
        total += d[i]
        if total > budget:
            return i
    
    return len(d)