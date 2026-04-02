<template>
  <div><h2>콘솔 확인</h2></div>
</template>

<script setup>
import axios from 'axios';

const requestAPI = () => {
  // const url = 'http://localhost:3000/todos/1';

  // => vite.config.js에 proxy server 설정
  const url = '/api/todos/1';

  axios.get(url).then((response) => {
    console.log('# 응답객체 : ', response);
  });

  // => promise 객체를 return하는 경우 async-await 사용 가능
};

requestAPI();
</script>
