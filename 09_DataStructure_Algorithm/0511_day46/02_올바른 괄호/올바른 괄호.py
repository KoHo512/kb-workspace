def solution(s):
    check = []
    
    for ss in s:
        if ss == "(":
            check.append("(")
        else:
            if not check:
                return False
            
            check.pop()
    
    if check:
        return False
    return True