# https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=python3

def solution(s):
    stack = []
    
    for ch in s:
        if stack and stack[-1] == ch:
            stack.pop()
        else:
            stack.append(ch)
            
    if stack:
        return 0
    return 1


## 강의 코드
def solution(s):
    # 스택 만들기
    stk = []
    
    # 모든 데이터 확인
    for i in s:
        # 비어 있다면
        if len(stk) == 0:
            # 넣기
            stk.append(i)
        # 아니면
        else:
            # 마지막 데이터가 지금 데이터와 같으면
            if stk[-1] == i:
                # 빼기
                stk.pop()
            # 아니면
            else:
                # 넣기
                stk.append(i)
                
    # 끝나고
    # 데이터가 존재하면 제거 안 됨
    if len(stk) != 0:
        return 0
    
    # 데이터가 없으면 모두 제거됨
    return 1