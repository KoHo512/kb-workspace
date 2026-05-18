from itertools import permutations

def solution(k, dungeons):
    answer = -1
    
    for permu in permutations(dungeons):
        count = 0
        tmpk = k
        
        for dungeon in permu:
            if tmpk >= dungeon[0]:
                tmpk -= dungeon[1]
                count += 1
            else:
                break
        
        answer = max(answer, count)
        
    return answer