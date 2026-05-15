def solution(new_id):
    # 1단계
    id = new_id.lower()
    
    # 2단계
    tmp = ""
    for c in id:
        if c.islower() or c.isdigit() or c in ["-", "_", "."]:
            tmp += c
    id = tmp
    
    # 3단계
    while ".." in id:
        id = id.replace("..", ".")

    # 4단계
    id = id.strip(".")
    
    # 5단계
    if not id:
        id = "a"
        
    # 6단계
    if len(id) >= 16:
        id = id[:15]
        id = id.rstrip(".")
    
    # 7단계
    while len(id) < 3:
        id += id[-1]
    
    return id