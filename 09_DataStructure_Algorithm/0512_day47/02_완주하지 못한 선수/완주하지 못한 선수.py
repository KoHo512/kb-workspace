def solution(participant, completion):
    for p in participant:
        if p not in completion:
            return p
        
        completion.remove(p)
# => 효율성 테스트 통과 X