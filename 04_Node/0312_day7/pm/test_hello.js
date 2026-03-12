import http from 'k6/http';

// 가상 유저 100명이 10초 동안 계속 요청
export const options = {
  vus: 100,
  duration: '10s',
};

export default function () {
  http.get('http://localhost:8000');
}
