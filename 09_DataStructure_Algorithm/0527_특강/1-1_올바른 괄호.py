# https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=python3

def solution(s):
    stk = []
    
    for ch in s:
        if ch == '(':
            stk.append('(')
        else:
            if not stk:
                return False
            stk.pop()
    
    if stk:
        return False
    
    return True


## 강의 코드
def solution(s):
    stk = []
    
    # 모든 문자 체크
    for i in s:
        # 여는 괄호면 넣기
        if i == '(':
            stk.append('(')
            
        # 닫는 괄호면 빼기
        else:
            # 그런데 뺄 때 비어있으면
            if len(stk) == 0:
                # 올바르지 않은 괄호
                return False
            
            # 비어있지 않으면 빼기
            else:
                stk.pop()
    
    # 모든 문자 체크가 끝나고
    # 비어 있다면 올바른 괄호
    
    if len(stk) == 0:
        return True
    
    # 남아 있다면 올바르지 않은 괄호
    return False