def solution(nums):
    total = 0
    length = len(nums)
    
    def check_prime(num):
        for i in range(2, int(num**(1/2)) + 1):
            if num % i == 0:
                return False
        return True
        
    for i in range(0, length - 2):
        for j in range(i + 1, length - 1):
            for k in range(j + 1, length):
                if check_prime(nums[i] + nums[j] + nums[k]):
                    total += 1
                    
    return total