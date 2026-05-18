def solution(numbers, target):
    answer = 0
    
    def combi(idx, total):
        nonlocal answer
        
        if idx == len(numbers):
            if total == target:
                answer += 1
            return
        
        combi(idx + 1, total + numbers[idx])
        combi(idx + 1, total - numbers[idx])
    
    combi(0, 0)
    
    return answer