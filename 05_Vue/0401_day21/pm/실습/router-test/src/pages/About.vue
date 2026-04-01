<template>
  <div class="card card-body">
    <h2>About</h2>
    <p>소개 페이지입니다.</p>
    <p>요청 경로 : {{ $route.fullPath }}</p>
  </div>
</template>

<script>
export default {
  name: 'About',
  created() {
    // 라우터 객체 콘솔에 출력
    console.log(this.$route);
  },
};
</script>
