<script setup>
import axios from 'axios';

const getData = () => {
  axios
    .get('api/data')
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => {
      console.log(`데이터 가져오던 중 오류 발생 : ${error}`);
    });
};

const postData = () => {
  axios
    .post('api/data', {
      name: 'new data',
      description: '테스트 데이터',
    })
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => {
      console.log(`데이터 추가하던 중 오류 발생 : ${error}`);
    });
};
</script>

<template>
  <div>
    <button type="button" @click="postData">POST</button>
    <br />
    <button type="button" @click="getData">GET</button>
    <br />
    <button type="button">PUT</button>
    <br />
    <button type="button">PATCH</button>
    <br />
  </div>
</template>

<style scoped></style>
