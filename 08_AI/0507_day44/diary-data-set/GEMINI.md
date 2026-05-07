# Project: 일기장 테스트 데이터 구축

## Tech Stack

- Framework: json-server@v1.0.0-beta.15
- 데이터 양식: json
- 데이터 파일명: db.json

## Instructions

- 엔드포인트: diary
- 일기 저장 항목
  - id: PK, 문자열
  - date: 읽기 해당 날짜 (시간 제외)
  - weather: 날씨
  - title: 제목
  - content: 일기 내용
  - createdAt: 작성일 , 시간
- 샘플 일기 데이터
  - 총 100 개
  - content는 500자 내외의 길이로 작성
  - 2026년 1월 1일부터 2026년 5월 6일까지 하루에 최대 1개
