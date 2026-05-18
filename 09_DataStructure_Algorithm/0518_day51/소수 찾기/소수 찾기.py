from itertools import permutations

def solution(numbers):
    answer = set()
    
    def check_prime(n):
        if n < 2:
            return False
        
        for i in range(2, int(n ** (1/2)) + 1):
            if n % i == 0:
                return False
        return True
    
    for i in range(len(numbers)):
        for permu in permutations(numbers, i + 1):
            num = int(''.join(permu))
            if check_prime(num):
                answer.add(num)
    
    return len(answer)