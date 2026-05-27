# https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=python3

def solution(routes):
    routes.sort(key=lambda x: x[1])
    
    answer = 1
    point = routes[0][1]
    
    for route in routes:
        if route[0] > point:
            answer += 1
            point = route[1]
    
    return answer


## 강의 코드
def solution(routes):
    answer = 0
    
    # 이차원 배열의 [i][1] 데이터를 중심으로 오름차순 정렬
    # 같으면 시작을 오름차순으로 정렬
    routes.sort(key = lambda x : (x[1], x[0]))
    
    # 첫 자동차의 출구 지점에 카메라 설치
    end = routes[0][1]
    answer += 1
    
    # 모든 자동차 체크
    for s, e in routes:
        # 꼬리(카메라 설치) 부분과 다음 자동차의 진입 부분을 비교
        # 초과하면 새로운 카메라 설치
        if end < s:
            # 설치 위치 갱신
            end = e
            # 카메라 설치 카메라 설치
            answer += 1
    
    return answer