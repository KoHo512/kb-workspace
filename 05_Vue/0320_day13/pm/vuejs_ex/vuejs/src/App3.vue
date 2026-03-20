<script setup>
  // const message = "There!";
  // const message = {
  //   name: "Yeowon",
  //   major: "Computer"
  // }

  // const page = "history";

  let loading = true;
</script>

<template>
<!--  <div>-->
<!--    <span>Hello </span>-->
<!--    <span v-text="JSON.stringify(message)"></span>-->
<!--  </div>-->

<!--  <div v-bind:id="page">HISTORY PAGE</div>-->
<!--  <div :id="page">HISTORY PAGE</div>-->

  <input type="text" placeholder="아이디" :readonly="loading" />
  <input type="password" placeholder="비밀번호" :readonly="loading" />
  <button :disabled="loading">로그인</button>
</template>

<style scoped></style>