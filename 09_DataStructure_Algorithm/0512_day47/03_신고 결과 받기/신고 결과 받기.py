def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report_set = set(report)
    
    reports = {}
    for r in report_set:
        u1, u2 = r.split()
        if u2 in reports:
            reports[u2].append(u1)
        else:
            reports[u2] = [u1]
    
    blocked_users = []
    for r in reports:
        if len(reports[r]) >= k:
            blocked_users.append(r)
    
    for i in range(len(id_list)):
        for bu in blocked_users:
            if (id_list[i] in reports[bu]):
                answer[i] += 1
    
    return answer