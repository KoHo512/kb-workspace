# Project: Vue3 Diary App

## Tech Stack

### Frontend

- Framework: Vue 3 (Vite)
- API Style: Composition API (<script setup>)
- Styling: Bootstrap5
- State Management: Pinia (Composition API 사용)
- axios를 통한 백엔드 통신
- Icon Font: FontAwesome5

### Backend

- Framework: json-server@v1.0.0-beta.15
- 데이터 양식: json
- 데이터 파일명: db.json

## Instructions

- 모든 컴포넌트는 SFC 스타일로 작성
- 변수명은 camelCase, 파일명은 PascalCase 사용
- json server 엔드포인트: diary
- 일기 저장 항목
  - id: PK, 문자열
  - date: 일기 해당 날짜(시간 제외)
  - weather: 날씨
  - title: 제목
  - content: 일기 내용
  - createdAt: 작성일, 시간

### 페이지 구성

- 반응형 웹으로 화면 구성
  - sm에서 메뉴 접기, 그 이상에서는 형상 유지
- 타이틀, 레이블, 버튼, 링크 등을 만들 때 어울리는 FontAwesome 5 아이콘 사용
- 앱의 첫 페이지는 일기장 목록 페이지로 함
- 캘린더를 사용하여 일기 목록 표시
- 일기 쓰기/수정하기/일기보기는 개별 페이지로 이동하여 수행
