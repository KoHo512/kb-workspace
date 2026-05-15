def solution(prices):
    answer = []
    n = len(prices)
    
    for i in range(n):
        check = 0
        for j in range(i + 1, n):
            if prices[i] <= prices[j]:
                check += 1
            else:
                break
        answer.append(check)
            
    return answer